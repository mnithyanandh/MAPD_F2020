//
//  BMIDataViewController.swift
//  BMI_Calculator
//
//  Created by Nithyanandh Mahalingam on 12/12/20.
//

import UIKit
import FirebaseDatabase

class BMIDataViewController: UIViewController, UITableViewDelegate, UITableViewDataSource {
    
    // MARK: - TableView DELGATE & DATASOURCE METHODS
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return values.count
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: "Cell", for: indexPath) as! Cell
        
        // Assign Titles:
        cell.BMIValueTitle.text = "BMI"
        cell.WeightValueTitle.text = "WEIGHT"
        cell.DateValueTitle.text = "DATE"
        
        // Assign their values:
        cell.BMIValue.text = String(values[indexPath.row].BMI)
        cell.WeightValue.text = String(values[indexPath.row].Weight)
        cell.DateValue.text = String(values[indexPath.row].Date)
        return cell
    }
    
    func tableView(_ tableView: UITableView, trailingSwipeActionsConfigurationForRowAt indexPath: IndexPath) -> UISwipeActionsConfiguration? {
        let del = UIContextualAction(style: .destructive, title: "Delete"){(action,view,nil) in
        self.Delete(id: self.values[indexPath.row].id)
        }
        return UISwipeActionsConfiguration(actions: [del])
    }
    
    // MARK: - DATABASE DELETE METHOD:
    func Delete(id:String){
        db.child(id).setValue(nil)
    }
    
    // MARK: - TableViewCell CLASS:
    class Cell : UITableViewCell{
    
        // Declare Outlets for the Title Labels
        @IBOutlet weak var BMIValueTitle: UILabel!
        @IBOutlet weak var WeightValueTitle: UILabel!
        @IBOutlet weak var DateValueTitle: UILabel!
        
        // Declare Outlets for the Value Labels
        @IBOutlet weak var BMIValue: UILabel!
        @IBOutlet weak var WeightValue: UILabel!
        @IBOutlet weak var DateValue: UILabel!
    }
    
    // MARK: - Data HANDLER CLASS:
    class Data {
        var BMI = 0.0
        var Weight = 0.0
        var Date = ""
        var id = ""
    
        // Create a convienece instance to handle DB data:
        convenience init(BMI:Double, Weight:Double, Date:String, id:String){
            self.init()
            self.BMI = BMI
            self.Weight = Weight
            self.id = id
        }
    }
    
    // MARK: - DATABASE DATA STORAGE & REFERENCE POINT:
    var values : [Data] = []
    let db = Database.database().reference().child("BMI Data")
    
    // MARK: - BMIDataViewController OUTLETS:
    @IBOutlet weak var BMITableView: UITableView!
    
    override func viewDidLoad() {
        super.viewDidLoad()

        // DATABASE OPERATIONS:
        db.observe(DataEventType.value, with: { (snapshot) in
        self.values.removeAll()
            for values in snapshot.children.allObjects as! [DataSnapshot]
            {
                let dbObject = values.value as? [String : AnyObject]
                let bmiName = dbObject?["BMI Value"]
                let bmiWeight = dbObject?["Weight"]
                let bmiDate = dbObject?["Date"]
                let id = dbObject?["id"]
                
                let dbValue = Data(BMI: bmiName as! Double, Weight: bmiWeight as! Double, Date: bmiDate as! String, id: id as! String)
                
              self.values.append(dbValue)
            }
            self.BMITableView.reloadData()
        })
    }
}
