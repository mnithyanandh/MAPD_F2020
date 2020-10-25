//
//  File Name: CircleButton.swift
//  Created by Nithyanandh Mahalingam on 10/25/20
//  Student ID: 301162314
//  App: Calculator - Assignment 3
//
import UIKit

@IBDesignable
class CircleButton: UIButton {
    
    // Initialize the function of the circle button and set its init stage as 'false' for this interface
    @IBInspectable var circleButton:Bool = false{
        
        // Set the property of the circle button to crop the height
        didSet{
            if circleButton{
                // Assigning the circle radius
                layer.cornerRadius = frame.height / 2
            }
        }
    }
    
    // Prepare an override function for the delcared circle Button that reverts to the interface declared above
    override func prepareForInterfaceBuilder() {
        if circleButton{
            layer.cornerRadius = frame.height / 2
        }
    }
}
