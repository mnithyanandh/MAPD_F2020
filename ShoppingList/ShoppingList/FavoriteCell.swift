//
//  FavoriteCell.swift
//  ShoppingList
//
//  Created by Nithyanandh Mahalingam on 10/30/20.
//

import UIKit

class FavoriteCell: UITableViewCell {
    
    override init(style: UITableViewCell.CellStyle, reuseIdentifier: String?){
        let fav = UIButton(type: .system)
        fav.setTitle("THIS", for: .normal)
        fav.setImage(fav_heart, for: .normal)
        fav.frame = CGRect(x: 0, y: 0, width: 50, height: 50)
        accessoryView = fav
        super.init(style: <#T##UITableViewCell.CellStyle#>, reuseIdentifier: <#T##String?#>)
    }
    
    required init?(coder: NSCoder) {
        fatalError("init(coder:) has not been implemented")
    }
    
}
