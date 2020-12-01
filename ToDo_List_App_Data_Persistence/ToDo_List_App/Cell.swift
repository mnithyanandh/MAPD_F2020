//  File name: Cell.swift
//
//  Author's name: Created by Nithyanandh Mahalingam on 11/29/20.
//  StudentID: 301162314
//  Date: 11/29/20
//  App description: ToDo_List_App
//

import Foundation

// Create an enum class for handling segue operations between Edit and Add option
enum Handler{
    case CEdit
    case CAdd
}

class Cell
{
    // Initialize Task details holder for each Cell
    var Cname = ""
    var Cdate = ""
    var Ccomplete = false
    var Cdescp = ""
    var Cddate = true
    var Cdb_key = ""
    var index = 0
    
    // Declare a secondary initialization of said above variables to link with DB as well as UITableViewController
    // Convinence Init is helpful here:
    convenience init(Cname: String, Cdate: String, Ccomplete: Bool, Cdescp: String, Cddate: Bool, Cdb_key: String, index:Int) {
        
        self.init()
        self.Cname = Cname
        self.Cdate = Cdate
        self.Ccomplete = Ccomplete
        self.Cdescp = Cdescp
        self.Cddate = Cddate
        self.Cdb_key = Cdb_key
        self.index=index
    }
}
