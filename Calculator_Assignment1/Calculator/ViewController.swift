//
//  File Name: ViewController.swift
//  Created by Nithyanandh Mahalingam on 10/08/20
//  Student ID: 301162314
//  App: Calculator - Assignment 2
//

import UIKit
import Foundation

// Create an 'enum' struct holder to hold the Operator functions
enum Operator:String{
    case Multiply = "*"
    case Divide = "/"
    case Add = "+"
    case Subtract = "-"
    case Percentage = "%"
    case Default = "null"
}

class ViewController: UIViewController {
    // Declaring the Operand places
    var  LOperand = ""
    var ROperand = ""
    var Output = ""
    // Declare a counter to track the current key pressed by the user
    var PressedKey = ""
    //Declare a counter to track the current operation
    var MathOperation:Operator = .Default
    // Declare a variable for the percentage divisor
    var CentValue: Int = 100
    
    // IBOutlet Link for the 'Result' area
    @IBOutlet weak var resultLabel: UILabel!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Initialize the output area label to "0"
        resultLabel.text = "0"
    }
    
    // Function declaration for all Operations
        func math(operation: Operator){
            if MathOperation != .Default && MathOperation != .Percentage{
                if PressedKey != ""{
                    ROperand = PressedKey
                    PressedKey = ""
                    if MathOperation == .Add{
                        // Addition operation between LOperand and ROperand
                        Output = "\(Double(LOperand)! + Double(ROperand)!)"
                    }else if MathOperation == .Subtract{
                        // Subtract operation between LOperand and ROperand
                        Output = "\(Double(LOperand)! - Double(ROperand)!)"
                    }else if MathOperation == .Multiply{
                        // Multiplication operation between LOperand and ROperand
                        Output = "\(Double(LOperand)! * Double(ROperand)!)"
                    }else if MathOperation == .Divide{
                        // Division operation between LOperand and ROperand
                        Output = "\(Double(LOperand)! / Double(ROperand)!)"
                    }
                    LOperand = Output
                    // To get rid of unecessary floating point
                    if (Double(Output)!.truncatingRemainder(dividingBy: 1) == 0){
                        // Downcast the Double to a Integer and then string interpolate it
                        Output = "\(Int(Double(Output)!))"
                    }
                    // Print Output
                    resultLabel.text = Output
                }
                // Return the value of the performed operation
                MathOperation = operation
            }
            // Since Percentage operation only takes 1 operand - LOperand
            else if MathOperation == .Percentage{
                LOperand = resultLabel.text!
                PressedKey = ""
                Output = "\(Double(LOperand)! / Double(CentValue))"
                LOperand = Output
                resultLabel.text = Output
                MathOperation = operation
            }
        else{
                LOperand = PressedKey
                PressedKey = ""
                MathOperation = operation
            }
        }

    // IBAction for all the pressable numeric circleButtons  - Numbers
    @IBAction func numberPress(_ sender: CircleButton) {
        // Max number of digits allowed in the Output window = 10
        if PressedKey.count <= 10{
            // On user press of any key, detect the key tag and assign to 'CurrentNumber'
            PressedKey += "\(sender.tag)"
            // Apply changes to the Result Label to display the pressed key to the user
            resultLabel.text = PressedKey
        }
    }
    
    // IBAction for all the pressable operator circleButtons - Operators
    // - ADD Operator:
    @IBAction func addPress(_ sender: CircleButton) {
        math(operation: .Add)
    }
    
    // - SUBTRACT Operator:
    @IBAction func subtractPress(_ sender: CircleButton) {
        math(operation: .Subtract)
    }
    
    // - MULTIPLY Operator:
    @IBAction func multiplyPress(_ sender: CircleButton) {
        math(operation: .Multiply)
    }
     
    // - DIVIDE Operator:
    @IBAction func dividePress(_ sender: CircleButton) {
        math(operation: .Divide)
    }
    
    // - PERCENTAGE Operator:
    @IBAction func percentagePress(_ sender: CircleButton) {
        math(operation: .Percentage)
    }
    
    // - EQUALS Operation
    @IBAction func equalsPress(_ sender: CircleButton) {
        math(operation: MathOperation)
    }
    
    // IBAction for clearing results circleButton - Clear
    @IBAction func clearPress(_ sender: CircleButton) {
        // On user press, clear and assign all default values to the operators, operands, output screen and counters
        if (PressedKey) != "0" && (PressedKey.count) <= 11 && Output.isEmpty == true{
            resultLabel.text?.removeLast()
            PressedKey = resultLabel.text!
            if resultLabel.text?.isEmpty == true{
                resultLabel.text = "0"
                PressedKey = ""
            }
        }else{
            // ALL-CLEAR values
            LOperand = ""
            ROperand = ""
            PressedKey = ""
            MathOperation = .Default
            Output = ""
            resultLabel.text = "0"
        }
    }
    
    // IBAction for decimal circleButton - Decimal
    @IBAction func decimalPress(_ sender: CircleButton) {
        // Need to make sure the last digit entered is not a decimal
        if PressedKey.count <= 10{
            // Need to make sure decimal is allowed only once
            if PressedKey.contains(".") != true{
                // On user press, detect the key tag and assign to '.'
                PressedKey += "."
                // Apply changes to the Result Label to display the pressed key to the user
                resultLabel.text = PressedKey
            }
        }
    }
    
    // IBAction for signed circleButton - Signed button
    @IBAction func signedPress(_ sender: CircleButton) {
        // Need to make sure that we are not negating just a decimnal
        if PressedKey.contains(".") != true{
            // Need to make sure that the last digit entered is not a decimal
            if PressedKey.count <= 10 && resultLabel.text!.contains("-") != true{
                // Add the "-" negation operator
                let (negativeVal): Double = -(Double(resultLabel.text!)!)
                resultLabel.text = String(negativeVal)
            }else if PressedKey.count <= 10 && resultLabel.text!.contains("-") == true{
                resultLabel.text = resultLabel.text!.replacingOccurrences(of: "-", with: "")
                
            }
        }
    }
}

