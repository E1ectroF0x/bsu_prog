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
        self.tableView.register(UserInfoCell.self, forCellReuseIdentifier: "UserInfoCell")

        
    }
    

    // MARK: - Table view data source
    
    override func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        
        return Constants.USER_INFO_NAME_CELL.count
    }
    
    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = self.tableView.dequeueReusableCell(withIdentifier: "UserInfoCell", for: indexPath) as! UserInfoCell
    
        cell.contentView.frame = CGRect(x: 20, y: 0, width: view.frame.width-40, height: 44)
        cell.updateUI()
        cell.infoNameLabel.text = Constants.USER_INFO_NAME_CELL[indexPath.row]
        cell.infoLabel.text = Constants.INFO_TABLE_INFO[indexPath.row]
        
        return cell
    }
    
    // MARK: -Delegate
    
}
