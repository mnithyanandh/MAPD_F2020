//
//  ViewController.swift
//  BMI_Calculator
//
//  Created by Nithyanandh Mahalingam on 12/10/20.
//

import UIKit
import FirebaseDatabase

class ViewController: UIViewController {
    
    let db = Database.database().reference().child("BMI Data")

    // MARK: - OUTLETS:
    
    @IBOutlet weak var PersonalName: UITextField!
    @IBOutlet weak var PersonalAge: UITextField!
    @IBOutlet weak var PersonalHeight: UITextField!
    @IBOutlet weak var PersonalWeight: UITextField!
    @IBOutlet weak var BMIValue: UILabel!
    @IBOutlet weak var BMIMessage: UILabel!
    
    @IBOutlet weak var GenderHandler: UISegmentedControl!
    @IBOutlet weak var MeasurementHandler: UISegmentedControl!
    
    //MARK: - GENDER CONTROL SEGMENT FUNCTION:
    @IBAction func GenderController(_ sender: Any) {
        let genderController = GenderHandler.titleForSegment(at: GenderHandler.selectedSegmentIndex)
        
        if (genderController == "Male"){
            GenderHandler.selectedSegmentIndex = 0
        }
        else if(genderController == "Female"){
            GenderHandler.selectedSegmentIndex = 1
        }
    }
    
    // MARK: - MEASUREMENT CONTROL SEGMENT FUNCTION:
    @IBAction func MeasurementController(_ sender: Any) {
        let measurementController = MeasurementHandler.titleForSegment(at: MeasurementHandler.selectedSegmentIndex)
        
        if(measurementController == "Metric"){
            MeasurementHandler.selectedSegmentIndex = 0
            PersonalHeight.attributedPlaceholder = NSAttributedString(string:"Meters(m)", attributes: [NSAttributedString.Key.foregroundColor:UIColor.white])
            PersonalWeight.attributedPlaceholder = NSAttributedString(string:"Kilograms(kgs)", attributes: [NSAttributedString.Key.foregroundColor:UIColor.white])
            
        }
        else if(measurementController == "Imperial"){
            MeasurementHandler.selectedSegmentIndex = 1
            PersonalHeight.attributedPlaceholder = NSAttributedString(string:"Inches(in)", attributes: [NSAttributedString.Key.foregroundColor:UIColor.white])
            PersonalWeight.attributedPlaceholder = NSAttributedString(string:"Pounds(lbs)", attributes: [NSAttributedString.Key.foregroundColor:UIColor.white])
        }
    }
    
    // MARK: - CALCULATE BMI FUNCTION:
    @IBAction func CalculateBMI(_ sender: Any) {
        
        // Creaste instances for user data:
        let user_name = PersonalName.text
        let user_age = Int(PersonalAge.text!)
        let user_height = Double(PersonalHeight.text!)
        let user_weight = Double(PersonalWeight.text!)
        let user_gender = GenderHandler.titleForSegment(at: GenderHandler.selectedSegmentIndex)
        let user_measurement_choice = MeasurementHandler.titleForSegment(at: MeasurementHandler.selectedSegmentIndex)
        
        // Register a Date Formatter to save the current date to the Database:
        let DF = DateFormatter()
        DF.dateFormat = "MM/dd/yyyy"
        view.endEditing(true)
        let today = DF.string(from: Date())
        
        // Perform Metric Conversion:
        if(user_measurement_choice == "Metric"){
            
            // Formula for Metric BMI conversion:
            let bmi_calculation = (user_weight!/(user_height! * user_height!))
            PersonalHeight.attributedPlaceholder = NSAttributedString(string:"Meters(m)", attributes: [NSAttributedString.Key.foregroundColor:UIColor.white])
            PersonalWeight.attributedPlaceholder = NSAttributedString(string:"Kilograms(kgs)", attributes: [NSAttributedString.Key.foregroundColor:UIColor.white])
            
            if (bmi_calculation <= 16){
                BMIValue.text = "Your BMI value is: "+String(bmi_calculation)
                BMIMessage.text = "You are Severely Thin. Eat lots of food and possibly consult a doctor!"
            }
            else if(bmi_calculation > 16 && bmi_calculation < 17){
                BMIValue.text = "Your BMI value is: "+String(bmi_calculation)
                BMIMessage.text = "You are Moderately Thin. Eat up well and drink lots of water!"
            }
            else if(bmi_calculation >= 17 && bmi_calculation < 18){
                BMIValue.text = "Your BMI value is: "+String(bmi_calculation)
                BMIMessage.text = "You are Mildly Thin. Eat better nutritious food!"
            }
            else if(bmi_calculation > 18 && bmi_calculation < 25){
                BMIValue.text = "Your BMI value is: "+String(bmi_calculation)
                BMIMessage.text = "Your BMI is Normal. Keep it up!"
            }
            else if(bmi_calculation > 25 && bmi_calculation < 30){
                BMIValue.text = "Your BMI value is: "+String(bmi_calculation)
                BMIMessage.text = "You are Overweight. Get those workouts in!"
            }
            else if(bmi_calculation > 30 && bmi_calculation < 35){
                BMIValue.text = "Your BMI value is: "+String(bmi_calculation)
                BMIMessage.text = "You would be classified as Obese Lvl 1"
            }
            else if(bmi_calculation > 35 && bmi_calculation < 40){
                BMIValue.text = "Your BMI value is: "+String(bmi_calculation)
                BMIMessage.text = "You would be classified as Obese Lvl 2"
            }
            else if(bmi_calculation > 40){
                BMIValue.text = "Your BMI value is: "+String(bmi_calculation)
                BMIMessage.text = "You would be classified as Obese Lvl 3"
            }
            
            // Add BMI results to Firebase:
            let Key = db.childByAutoId().key
            let dbObject :[String: Any] =  ["BMI Value":bmi_calculation,
                                            "Name":user_name!,
                                            "Age":user_age!,
                                            "Gender":user_gender!,
                                            "Height":user_height!,
                                            "Weight":user_weight!,
                                            "id":Key!,
                                            "Date":today]
            db.child(Key!).setValue(dbObject)
        }
        else{
            // Formula for Metric BMI conversion:
            let bmi_calculation = ((user_weight! * 703)/(user_height! * user_height!))
            PersonalHeight.attributedPlaceholder = NSAttributedString(string:"Inches(in)", attributes: [NSAttributedString.Key.foregroundColor:UIColor.white])
            PersonalWeight.attributedPlaceholder = NSAttributedString(string:"Pounds(lbs)", attributes: [NSAttributedString.Key.foregroundColor:UIColor.white])
            
            if (bmi_calculation <= 16){
                BMIValue.text = "Your BMI value is: "+String(bmi_calculation)
                BMIMessage.text = "You are Severely Thin. Eat lots of food and possibly consult a doctor!"
            }
            else if(bmi_calculation > 16 && bmi_calculation < 17){
                BMIValue.text = "Your BMI value is: "+String(bmi_calculation)
                BMIMessage.text = "You are Moderately Thin. Eat up well and drink lots of water!"
            }
            else if(bmi_calculation >= 17 && bmi_calculation < 18){
                BMIValue.text = "Your BMI value is: "+String(bmi_calculation)
                BMIMessage.text = "You are Mildly Thin. Eat better nutritious food!"
            }
            else if(bmi_calculation > 18 && bmi_calculation < 25){
                BMIValue.text = "Your BMI value is: "+String(bmi_calculation)
                BMIMessage.text = "Your BMI is Normal. Keep it up!"
            }
            else if(bmi_calculation > 25 && bmi_calculation < 30){
                BMIValue.text = "Your BMI value is: "+String(bmi_calculation)
                BMIMessage.text = "You are Overweight. Get those workouts in!"
            }
            else if(bmi_calculation > 30 && bmi_calculation < 35){
                BMIValue.text = "Your BMI value is: "+String(bmi_calculation)
                BMIMessage.text = "You would be classified as Obese Lvl 1"
            }
            else if(bmi_calculation > 35 && bmi_calculation < 40){
                BMIValue.text = "Your BMI value is: "+String(bmi_calculation)
                BMIMessage.text = "You would be classified as Obese Lvl 2"
            }
            else if(bmi_calculation > 40){
                BMIValue.text = "Your BMI value is: "+String(bmi_calculation)
                BMIMessage.text = "You would be classified as Obese Lvl 3"
            }
            
            // Add BMI results to Firebase:
            let Key = db.childByAutoId().key
            let dbObject :[String: Any] =  ["BMI Value":bmi_calculation,
                                            "Name":user_name!,
                                            "Age":user_age!,
                                            "Gender":user_gender!,
                                            "Height":user_height!,
                                            "Weight":user_weight!,
                                            "id":Key!,
                                            "Date":today]
            db.child(Key!).setValue(dbObject)
        }
    }
    
    // MARK: - RESET FUNCTION:
    @IBAction func Reset(_ sender: Any) {
        let Alert = UIAlertController.init(title: "Reset", message: "Reset all entry fields?", preferredStyle:.alert)
                Alert.addAction(UIAlertAction(title: "Yes", style: .destructive, handler: {action in
                    self.PersonalName.text=""
                    self.PersonalAge.text=""
                    self.PersonalHeight.text=""
                    self.PersonalWeight.text=""
                    self.navigationController?.popViewController(animated: true)
                }))
                Alert.addAction(UIAlertAction(title: "Cancel", style: .cancel, handler: {action in ()}))
                self.navigationController?.popViewController(animated: true)
                present(Alert,animated: true)
    }
    
    // MARK: - VIEW_CONTROLLER viewDidLoad() FUNCTION:
    override func viewDidLoad() {
        super.viewDidLoad()
        
        // Declare placeholders for text input fields:
        PersonalName.attributedPlaceholder = NSAttributedString(string:"Name", attributes: [NSAttributedString.Key.foregroundColor:UIColor.white])
        PersonalAge.attributedPlaceholder = NSAttributedString(string:"Age", attributes: [NSAttributedString.Key.foregroundColor:UIColor.white])
        
    }
}

