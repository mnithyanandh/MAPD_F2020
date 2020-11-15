//
//  CustomCell.swift
//  ToDo_List_App
//
//  Created by Nithyanandh Mahalingam on 11/14/20.
//

import Foundation

import UIKit
class CustomCell: UITableViewCell {

    @IBOutlet weak var TaskNameLbl: UILabel!
    @IBOutlet weak var DueDateLbl: UILabel!
    @IBOutlet weak var TaskActiveSwitch: UISwitch!
    @IBOutlet weak var TaskEditBtn: UIButton!
}
