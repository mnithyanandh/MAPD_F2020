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
    func Add_task(th_name: String, th_date: String, th_iscomplete: Bool, th_descp: String, th_ddate: Bool, th_db_key: String) {
        let th_db_key = db.childByAutoId().key
        let dbobject :[String: Any] =  ["name":th_name,"due-date":th_date,"description":th_descp,"checked":th_iscomplete,"due-date-specified":th_ddate,"id":th_db_key!]
        db.child(th_db_key!).setValue(dbobject)
    }
    
    func Edit_task(th_name: String, th_date: String, th_iscomplete: Bool, th_descp: String, th_ddate: Bool, th_db_key: String) {
        let dbobject :[String: Any] =  ["name":th_name,"due-date":th_date,"description":th_descp,"checked":th_iscomplete,"due-date-specified":th_ddate,"id":th_db_key]
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
                    let user_task_name = user_task_object?["Name:"]
                    let user_task_date = user_task_object?["Date:"]
                    let user_task_isComplete = user_task_object?["isComplete:"]
                    let user_task_description = user_task_object?["Description:"]
                    let user_task_due_date = user_task_object?["hasDueDate:"]
                    let user_task_key = user_task_object?["id_key:"]
                    
                    // Create child - Task under entity with above variables in the table:
                    let utasks = Cell(Cname: user_task_name as! String, Cdate: user_task_date as! String, Ccomplete: (user_task_isComplete?.boolValue ?? false), Cdescp: user_task_description as! String, Cddate: (user_task_due_date?.boolValue ?? true), Cdb_key: user_task_key as! String)
                    
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
                                          Cdb_key: user_tasks[sender.tag].Cdb_key
                             ),
                     taction: Handler.CEdit))
    }
    
    // MARK: - Function for Primary Segue Transition:
    override func prepare(for segue: UIStoryboardSegue, sender: Any?){
        if segue.identifier == "AddMoreSegue" {
            let next_screen = segue.destination as! TaskDetailsViewController
            if let next_screen_data = sender as? (UTask: Cell, UAction: Handler)
            {
                next_screen.tname = next_screen_data.UTask.Cname
                next_screen.tdate = next_screen_data.UTask.Cdate
                next_screen.tdescription = next_screen_data.UTask.Cdescp
                next_screen.getduedate=next_screen_data.UTask.Cddate
                next_screen.getiscomplete=next_screen_data.UTask.Ccomplete
                next_screen.tdbkey = next_screen_data.UTask.Cdb_key
                next_screen.taction = next_screen_data.UAction
            }
            next_screen.tdelegate=self
        }
    }
}
