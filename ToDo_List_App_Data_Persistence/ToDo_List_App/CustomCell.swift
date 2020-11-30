//  File name: CustomCell.swift
//
//  Author's name: Created by Nithyanandh Mahalingam on 11/29/20.
//  StudentID: 301162314
//  Date: 11/29/20
//  App description: ToDo_List_App
//

import Foundation

import UIKit
class CustomCell: UITableViewCell {

    @IBOutlet weak var TaskNameLbl: UILabel!
    @IBOutlet weak var DueDateLbl: UILabel!
    @IBOutlet weak var TaskActiveSwitch: UISwitch!
    @IBOutlet weak var TaskEditBtn: UIButton!
}
