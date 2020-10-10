//
//  File Name: ViewController.swift
//  Created by Nithyanandh Mahalingam on 10/08/20
//  Student ID: 301162314
//  App: Calculator - Assignment 2
//

import UIKit
import Foundation

class ViewController: UIViewController {
    
    // IBOutlet Link for the 'Result' area
    @IBOutlet weak var resultLabel: UILabel!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Initialize the output area label to "0"
        resultLabel.text = "0"
    }

    // IBAction for all the pressable numeric circleButtons  - Numbers
    @IBAction func numberPress(_ sender: CircleButton) {
    }
    
    // IBAction for all the pressable operator circleButtons - Operators
    // - ADD Operator:
    @IBAction func addPress(_ sender: CircleButton) {
    }
    
    // - SUBTRACT Operator:
    @IBAction func subtractPress(_ sender: CircleButton) {
    }
    
    // - MULTIPLY Operator:
    @IBAction func multiplyPress(_ sender: CircleButton) {
    }
     
    // - DIVIDE Operator:
    @IBAction func dividePress(_ sender: CircleButton) {
    }
    
    // - PERCENTAGE Operator:
    @IBAction func percentagePress(_ sender: CircleButton) {
    }
    
    // IBAction for clearing results circleButton - Clear
    @IBAction func clearPress(_ sender: CircleButton) {
    }
    
    // IBAction for decimal circleButton - Decimal
    @IBAction func decimalPress(_ sender: CircleButton) {
    }
    
    // IBAction for signed circleButton - Signed button
    @IBAction func signedPress(_ sender: CircleButton) {
    }
}

