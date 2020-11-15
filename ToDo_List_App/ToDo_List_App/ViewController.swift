//
//  ViewController.swift
//  ToDo_List_App
//
//  Created by Nithyanandh Mahalingam on 11/14/20.
//

import UIKit

class ViewController: UIViewController {
    
    var user_tasks =  [String]()
    var user_task_due = [Date]()
    
    override func viewDidLoad() {
        super.viewDidLoad()
    }
    @IBOutlet weak var UITableViewOutlet: UITableView!
    @IBAction func AddMoreTasks(_ sender: UIButton) {
    }
    @IBAction func DeleteTasks(_ sender: UIButton) {
    }
}

extension ViewController: UITableViewDelegate{
    func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        tableView.deselectRow(at: indexPath, animated: true)
    }
}
extension ViewController: UITableViewDataSource{
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return user_tasks.count
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let dateformat = DateFormatter()
        let cell = tableView.dequeueReusableCell(withIdentifier: "CustomCell", for: indexPath) as! CustomCell
        cell.TaskNameLbl.text = user_tasks[indexPath.row]
        cell.DueDateLbl.text = dateformat.string(from: user_task_due[indexPath.row])
        if(cell.TaskNameLbl.text != "Task 1")
        {
            cell.TaskActiveSwitch.isOn = true
        }
        else{
            cell.TaskActiveSwitch.isOn = false
        }
        
        return cell
    }
}

