//  File name: ViewController.swift
//
//  Author's name: Created by Nithyanandh Mahalingam on 11/29/20.
//  StudentID: 301162314
//  Date: 11/29/20
//  App description: ToDo_List_App
//

import UIKit
import FirebaseDatabase

class ViewController: UIViewController, UITableViewDelegate, UITableViewDataSource, TaskHandler{
    
    // MARK: - Link to the Firebase to call/create a child
    let db = Database.database().reference().child("Tasks")
    
    // MARK: - TaskHandler functions to reference TaskDetailsViewController
    func Add_task(th_name: String, th_date: String, th_iscomplete: Bool, th_descp: String, th_ddate: Bool, th_db_key: String, index: Int) {
        let th_db_key = db.childByAutoId().key
        let dbobject :[String: Any] =  ["Name":th_name,"Date":th_date,"Description":th_descp,"isComplete":th_iscomplete,"hasDueDate":th_ddate,"id_key":th_db_key!, "index": index]
        db.child(th_db_key!).setValue(dbobject)
    }
    
    func Edit_task(th_name: String, th_date: String, th_iscomplete: Bool, th_descp: String, th_ddate: Bool, th_db_key: String, index: Int) {
        let dbobject :[String: Any] =  ["Name":th_name,"Date":th_date,"Description":th_descp,"isComplete":th_iscomplete,"hasDueDate":th_ddate,"id_key":th_db_key, "index": index]
        db.child(th_db_key).setValue(dbobject)
        UITableViewOutlet.reloadData()
    }
    
    func Del_task(th_db_key: String) {
        db.child(th_db_key).setValue(nil)
    }
    
    //MARK: - TableView Delegate Function:
    // TableView Delegate function
    func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        self.UITableViewOutlet.allowsSelection = false
        self.UITableViewOutlet.delegate = self
    }
    
    // MARK: - TableView DataSource Functions:
    // TableView DataSource Function #1
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return user_tasks.count
    }
    
    // TableView DataSource Function #2
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: "CustomCell", for: indexPath) as! CustomCell
        cell.TaskNameLbl.text = user_tasks[indexPath.row].Cname
        cell.DueDateLbl.text = user_tasks[indexPath.row].Cdate
        cell.TaskActiveSwitch.isOn = user_tasks[indexPath.row].Ccomplete
        cell.TaskEditBtn.tag=indexPath.row
        cell.TaskEditBtn.addTarget(self, action: #selector(EditTask(_:)), for: .touchUpInside)
        return cell
    }
    
    // MARK: - Array holder for the list of tasks entered
    var user_tasks: [Cell] = []
    
    // MARK: - Outlets:
    @IBOutlet weak var UITableViewOutlet: UITableView!
    
    // MARK: - viewDidLoad:
    override func viewDidLoad() {
        super.viewDidLoad()
        
        // Managing DB entry creation:
        db.observe(DataEventType.value, with: {(DSnap) in
            if(DSnap.childrenCount > 0){
                self.user_tasks.removeAll()
                
                // Read through all children to verify if they are not being present/duplicated
                for user_tasks in DSnap.children.allObjects as! [DataSnapshot]{
                    
                    // Assign instance creation object to access the entity in the DB:
                    let user_task_object = user_tasks.value as? [String: AnyObject]
                    
                    // Assign instances of task details under selected entity:
                    let user_task_name = user_task_object?["Name"]
                    let user_task_date = user_task_object?["Date"]
                    let user_task_isComplete = user_task_object?["isComplete"]
                    let user_task_description = user_task_object?["Description"]
                    let user_task_due_date = user_task_object?["hasDueDate"]
                    let user_task_key = user_task_object?["id_key"]
                    let user_task_index = user_task_object?["index"]
                    
                    // Create child - Task under entity with above variables in the table:
                    let utasks = Cell(Cname: user_task_name as! String, Cdate: user_task_date as! String, Ccomplete: (user_task_isComplete?.boolValue ?? false), Cdescp: user_task_description as! String, Cddate: (user_task_due_date?.boolValue ?? true), Cdb_key: user_task_key as! String, index: user_task_index as! Int)
                    
                    // Add the info created as a task to the task list to the entity table in the DB
                    self.user_tasks.append(utasks)
                }
                
                // Reload all data in the ToDo List Home Screen
                self.UITableViewOutlet.reloadData()
            }
        })
    }
    
    // MARK: - Function for Secondary Segue Transition
    @objc func EditTask(_ sender: UIButton) {
        
        // Manually create a segue to link Edit task operations in the same existing "Add More" segue
        performSegue(withIdentifier: "AddMoreSegue",
                     sender: (UTask: Cell(Cname: user_tasks[sender.tag].Cname,
                                          Cdate: user_tasks[sender.tag].Cdate,
                                          Ccomplete: user_tasks[sender.tag].Ccomplete,
                                          Cdescp: user_tasks[sender.tag].Cdescp,
                                          Cddate: user_tasks[sender.tag].Cddate,
                                          Cdb_key: user_tasks[sender.tag].Cdb_key,
                                          index: sender.tag
                     ),taction: Handler.CEdit))
    }
    
    // MARK: - Function for Primary Segue Transition:
    override func prepare(for segue: UIStoryboardSegue, sender: Any?)
    {
        if segue.identifier == "AddMoreSegue" {
           let destination = segue.destination as! TaskDetailsViewController
           
           //passing the data to "AddTaskViewController" once user enters it
           
           if let data = sender as? (UTask: Cell, taction: Handler)
           {    //using tuples to pass data from class and enum
            destination.tname = data.UTask.Cname
            destination.tdate = data.UTask.Cdate
            destination.tdescription = data.UTask.Cdescp
            destination.getiscomplete=data.UTask.Ccomplete
            destination.getduedate=data.UTask.Cddate
            destination.index=data.UTask.index
            destination.taction = data.taction
            destination.tdbkey=data.UTask.Cdb_key
           }
           else{
           print("Error")
           }
           
           destination.tdelegate=self
       }
    }
}
