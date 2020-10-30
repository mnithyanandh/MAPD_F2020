//
//  File name: ViewController.swift
//  App Name: ShoppingList
//  Student ID: 301162314
// Date: 10/30/2020
//  Author's name: Created by Nithyanandh Mahalingam
//

import UIKit

class ViewController: UIViewController, UITabViewDelegate, UITableViewDataSource {
    
    // Creating an Outlet for the Table View:
    @IBOutlet override var tableview : UITableView!

    override func viewDidLoad() {
        super.viewDidLoad()
        tableview.delegate = self
        tableview.dataSource = self
        
    }
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return 5
    }
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        
        let cell1 = tableview.dequeueReusableCell(withIdentifier: "cell1", for: indexPath)
        cell1.textLabel?.text = "Enter new List name:"
        return cell1
    }
}

