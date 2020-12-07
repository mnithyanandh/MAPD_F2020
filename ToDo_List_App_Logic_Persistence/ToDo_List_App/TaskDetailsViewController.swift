//  File name: TaskDetailsViewController.swift
//
//  Author's name: Created by Nithyanandh Mahalingam on 12/06/20.
//  StudentID: 301162314
//  Date: 12/06/20
//  App description: ToDo_List_App
//

import UIKit
import FirebaseDatabase

class TaskDetailsViewController: UIViewController, UITextFieldDelegate, UITextViewDelegate {

    // MARK: - Global Variables
    var tname: String = ""
    var tdate: String = ""
    var tiscomplete: Bool = false
    var getiscomplete: Bool = false
    var tdescription: String = ""
    var tduedate: Bool = true
    var getduedate: Bool = true
    var tdbkey = ""
    var index = 0
    var tdelegate: TaskHandler?
    var taction: Handler = .CAdd
    
    //MARK: - Add a variable counter to track if the Primary Prototype cell needs deletion or not
    var counter = 0
    
    // MARK: - IB_Outlets:
    @IBOutlet weak var TaskNameOutlet: UITextField!
    @IBOutlet weak var TaskDescriptionOutlet: UITextView!
    @IBOutlet weak var TaskDueDateOutlet: UISwitch!
    @IBOutlet weak var TaskIsCompletedOutlet: UISwitch!
    @IBOutlet weak var TaskDateOutlet: UIDatePicker!
    @IBOutlet weak var TaskSaveOutlet: UIButton!
    
    // MARK: - IB_Buttons:
    // Save / Add Button:
    @IBAction func TaskSaveButton(_ sender: Any) {
        switch taction{
        case .CAdd:
            if TaskNameOutlet.text != ""
            {
                tdelegate?.Add_task(th_name: TaskNameOutlet.text!,
                                    th_date: tdate,
                                    th_iscomplete: tiscomplete,
                                    th_descp: TaskDescriptionOutlet.text!,
                                    th_ddate: tduedate,
                                    th_db_key: "",
                                    index: index)
            }
                
        case .CEdit:
            let Alert = UIAlertController.init(title: "Save", message: "All changes will be Saved, confirm Action?",preferredStyle: .alert)
            Alert.addAction(UIAlertAction(title: "Update", style: .default, handler: { action in
                if self.TaskNameOutlet.text != ""
                {
                    self.tdelegate?.Edit_task(th_name: self.TaskNameOutlet.text!,
                                              th_date: self.tdate,
                                              th_iscomplete: self.tiscomplete,
                                              th_descp: self.TaskDescriptionOutlet.text!,
                                              th_ddate: self.tduedate,
                                              th_db_key: self.tdbkey,
                                              index: self.index)
                    self.navigationController?.popViewController(animated: true)
                }
                
            }))
            Alert.addAction(UIAlertAction(title: "Cancel", style: .cancel, handler: { action in ()}))
            present(Alert,animated: true)
        }
        navigationController?.popViewController(animated: true)
    }
    
    // Cancel Button:
    @IBAction func TaskCancelButton(_ sender: UIButton) {
        let Alert = UIAlertController.init(title: "Cancel", message: "Confirm Cancel all unsaved changes?", preferredStyle:.alert)
        Alert.addAction(UIAlertAction(title: "Yes", style: .destructive, handler: {action in
            self.TaskNameOutlet.text=""
            self.TaskDescriptionOutlet.text=""
            self.TaskDueDateOutlet.isOn=false
            self.TaskIsCompletedOutlet.isOn=false
            let date = Date()
            self.TaskDateOutlet.date = date
            self.navigationController?.popViewController(animated: true)
        }))
        Alert.addAction(UIAlertAction(title: "Cancel", style: .cancel, handler: {action in ()}))
        self.navigationController?.popViewController(animated: true)
        present(Alert,animated: true)
    }
    
    // Delete Button:
    @IBAction func TaskDeleteButton(_ sender: UIButton) {
        let Alert = UIAlertController .init(title: "Confirm Delete the selected Task?", message: "Any pending changes will apply after app restart", preferredStyle:.alert)
        Alert.addAction(UIAlertAction(title: "Yes", style: .destructive, handler: {action in
            self.tdelegate?.Del_task(th_db_key: self.tdbkey)
            self.navigationController?.popViewController(animated: true)
        } ))
        Alert.addAction(UIAlertAction(title: "Cancel", style: .cancel, handler: {action in ()}))
        present(Alert,animated: true)
    }
    
    // MARK: - Firebase DB Reference
    let db = Database.database().reference()
    
    // MARK: - ViewController
    override func viewDidLoad() {
        super.viewDidLoad()
        
        // Link the outlets to the Global Variables to reference and track user entries:
        TaskNameOutlet.text = tname
        TaskDescriptionOutlet.text = tdescription
        
        // Define today's date as the default date:
        TaskDateOutlet.minimumDate = Date()
        TaskDateOutlet.addTarget(self, action: #selector(UserDate(_:)), for: .valueChanged)
        
        // Track current Switch states:
        TaskDueDateOutlet.isOn = getduedate
        TaskIsCompletedOutlet.isOn = getiscomplete
        
        // Name Swap for Save button after Segue swap:
        switch taction{
            case .CAdd:
                TaskSaveOutlet.setImage(UIImage(systemName: "plus"), for:.normal )
                TaskSaveOutlet.setTitle("Add", for: .normal)
            case .CEdit:
                TaskSaveOutlet.setImage(UIImage(systemName: "rectangle.and.pencil.and.ellipsis"), for:.normal )
                TaskSaveOutlet.setTitle("Save", for: .normal)
        }
    }
    
    // MARK: - User Modified Date constraint for MM/DD/YYYY format
    @objc func UserDate(_ TaskDateOutlet:UIDatePicker){
        let date_format = DateFormatter()
        date_format.dateFormat = "MM/dd/yyyy"
        view.endEditing(true)
        tdate=date_format.string(from: TaskDateOutlet.date)
    }
    
    // MARK: - Due_Date Switch Opertion:
    @IBAction func TaskDueDateAction(_ sender: Any) {
        if TaskDueDateOutlet.isOn
        {
            tduedate=true
            TaskDateOutlet.isEnabled=true
        }
        else
        {
            tduedate=false
            TaskDateOutlet.isEnabled=false
        }
    }
    
    // MARK: - Is_Completed Switch Operation:
    @IBAction func TaskIsCompletedAction(_ sender: UISwitch) {
        if sender.isOn
        {
            tiscomplete = true
        }
        else
        {
            tiscomplete = false
        }
    }
    
    // MARK: - Text Field Editing Functions:
    func textFieldDidEndEditing(_ textField: UITextField){
        if textField.text != ""
        {
            TaskDueDateOutlet.isHidden=false
            TaskIsCompletedOutlet.isHidden=false
            TaskDescriptionOutlet.isHidden = false
        }
    }
}

// MARK: - Declare Protocol for Data transfer
protocol TaskHandler {
    func Add_task (th_name: String,
                   th_date: String,
                   th_iscomplete: Bool,
                   th_descp: String,
                   th_ddate: Bool,
                   th_db_key: String,
                   index: Int)
    func Edit_task(th_name: String,
                   th_date: String,
                   th_iscomplete: Bool,
                   th_descp: String,
                   th_ddate: Bool,
                   th_db_key: String,
                   index: Int)
    func Del_task(th_db_key: String)
    // func TaskStats(th_db_key: String)
}
