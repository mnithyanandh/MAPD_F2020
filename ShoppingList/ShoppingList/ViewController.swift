//
//  File name: ViewController.swift
//  App Name: ShoppingList
//  Student ID: 301162314
// Date: 10/30/2020
//  Author's name: Created by Nithyanandh Mahalingam
//

import UIKit

class ViewController: UIViewController, UIPickerViewDelegate, UIPickerViewDataSource {
    
    var message:String = "Do you wish to cancel without saving?"
    
    // Creating outlets for Picker Views:
    @IBOutlet weak var pcView1: UIPickerView!
    @IBOutlet weak var pcView2: UIPickerView!
    @IBOutlet weak var pcView3: UIPickerView!
    @IBOutlet weak var pcView4: UIPickerView!
    @IBOutlet weak var pcView5: UIPickerView!
    @IBOutlet weak var pcView6: UIPickerView!
    
    // Cerating outlets for Picker Labels:
    @IBOutlet weak var pcLabel1: UILabel!
    @IBOutlet weak var pcLabel2: UILabel!
    @IBOutlet weak var pcLabel3: UILabel!
    @IBOutlet weak var pcLabel4: UILabel!
    @IBOutlet weak var pcLabel5: UILabel!
    @IBOutlet weak var pcLabel6: UILabel!
    
    // Creating outlets for Item Text Fields:
    @IBOutlet weak var listName: UITextField!
    @IBOutlet weak var itemName1: UITextField!
    @IBOutlet weak var itemName2: UITextField!
    @IBOutlet weak var itemName3: UITextField!
    @IBOutlet weak var itemName4: UITextField!
    @IBOutlet weak var itemName5: UITextField!
    @IBOutlet weak var itemName6: UITextField!
    
    // Cancel Button to rest all fields.
    @IBAction func cancelButton(_ sender: UIButton) {
        let alertController:UIAlertController = UIAlertController(title: "Cancel", message: message, preferredStyle: UIAlertController.Style.alert)
        alertController.addAction(UIAlertAction(title: "Yes", style: .default, handler:{action in
            self.listName.text = ""
            self.itemName1.text = ""
            self.itemName2.text = ""
            self.itemName3.text = ""
            self.itemName4.text = ""
            self.itemName5.text = ""
            self.itemName6.text = ""
        }))
        alertController.addAction(UIAlertAction(title: "No", style: .cancel, handler: nil))
        self.present(alertController, animated: true)
    }
    
    // Declare arrays for PickerVIews:
    let arr1 = [Int](0...499)
    let arr2 = [Int](0...499)
    let arr3 = [Int](0...499)
    let arr4 = [Int](0...499)
    let arr5 = [Int](0...499)
    let arr6 = [Int](0...499)
    
    // Creating outlets for UI Buttons:
    @IBOutlet weak var saveOutlet: UIButton!
    @IBOutlet weak var cancelOutlet: UIButton!
    @IBOutlet weak var favoritesOutlet: UIButton!
    @IBOutlet weak var addmoreOutlet: UIButton!
    
    // Start of viewDidLoad:
    override func viewDidLoad() {
        super.viewDidLoad()
        
        // Adding Picker View Delegates & Data Sources:
        pcView1.delegate = self
        pcView1.dataSource = self
        pcView2.delegate = self
        pcView3.delegate = self
        pcView4.delegate = self
        pcView5.delegate = self
        pcView6.delegate = self
        
        pcView2.dataSource = self
        pcView3.dataSource = self
        pcView4.dataSource = self
        pcView5.dataSource = self
        pcView6.dataSource = self
        
        // Adding Shadows to buttons:
        // Save Button:
        saveOutlet.layer.shadowColor = UIColor.black.cgColor
        saveOutlet.layer.shadowOffset = CGSize(width: 5, height: 5)
        saveOutlet.layer.shadowRadius = 2
        saveOutlet.layer.shadowOpacity = 0.6
        
        // Cancel Button:
        cancelOutlet.layer.shadowColor = UIColor.black.cgColor
        cancelOutlet.layer.shadowOffset = CGSize(width: 5, height: 5)
        cancelOutlet.layer.shadowRadius = 2
        cancelOutlet.layer.shadowOpacity = 0.6
        
        // Favorites Button:
        favoritesOutlet.layer.shadowColor = UIColor.black.cgColor
        favoritesOutlet.layer.shadowOffset = CGSize(width: 5, height: 5)
        favoritesOutlet.layer.shadowRadius = 2
        favoritesOutlet.layer.shadowOpacity = 0.6
        
        // Add More Button:
        addmoreOutlet.layer.shadowColor = UIColor.black.cgColor
        addmoreOutlet.layer.shadowOffset = CGSize(width: 5, height: 5)
        addmoreOutlet.layer.shadowRadius = 2
        addmoreOutlet.layer.shadowOpacity = 0.6
    }
    
    override func didReceiveMemoryWarning() {
        // Dispose of any resources that can be recreated.
        super.didReceiveMemoryWarning()
    }
    
    // PickerView Method - numberOfComponents:
    func numberOfComponents(in pickerView: UIPickerView) -> Int {
        return 1
    }
    
    // PickerView Method - numberOfRowsInComponent:
    func pickerView(_ pickerView: UIPickerView, numberOfRowsInComponent component: Int) -> Int {
        if pcView1.tag == 1{
            return arr1.count
        }else if pcView2.tag == 2{
            return arr2.count
        }else if pcView3.tag == 3{
            return arr3.count
        }else if pcView4.tag == 4{
            return arr4.count
        }else if pcView5.tag == 5{
            return arr5.count
        }else{
            return arr6.count
        }
    }
    
    // PickerView Method - titleForRow:
    func pickerView(_ pickerView: UIPickerView, titleForRow row: Int, forComponent component: Int) -> String? {
        if pcView1.tag == 1{
            return "\(arr1[row])"
        }else if pcView2.tag == 2{
            return "\(arr2[row])"
        }else if pcView3.tag == 3{
            return "\(arr3[row])"
        }else if pcView4.tag == 4{
            return "\(arr4[row])"
        }else if pcView5.tag == 5{
            return "\(arr5[row])"
        }else{
            return "\(arr6[row])"
        }
    }
    
    // PickerView Method - didSelectRow:
    func pickerView(_ pickerView: UIPickerView, didSelectRow row: Int, inComponent component: Int) {
        if pcView1.tag == 1{
            return pcLabel1.text = "\(arr1[row])"
        }else if pcView2.tag == 2{
            return pcLabel2.text = "\(arr2[row])"
        }else if pcView3.tag == 3{
            return pcLabel3.text = "\(arr3[row])"
        }else if pcView4.tag == 4{
            return pcLabel4.text = "\(arr4[row])"
        }else if pcView5.tag == 5{
            return pcLabel5.text = "\(arr5[row])"
        }else{
            return pcLabel6.text = "\(arr6[row])"
        }
    }
}
