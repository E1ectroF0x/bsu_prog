//
//  ProfileTableViewController.swift
//  tableSettigins
//
//  Created by Li on 12/10/19.
//  Copyright © 2019 Li. All rights reserved.
//

import UIKit

class InfoPageTableViewController: UITableViewController {
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
    }
    

    // MARK: - Table view data source
    
    override func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        
        return Constants.USER_INFO_NAME_CELL.count
    }
    
    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = UITableViewCell()
        
        cell.textLabel?.text = Constants.USER_INFO_NAME_CELL[indexPath.row]
        
        return cell
    }
    

    
}
