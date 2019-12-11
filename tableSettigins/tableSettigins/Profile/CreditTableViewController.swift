//
//  CreditTableViewController.swift
//  tableSettigins
//
//  Created by Li on 12/10/19.
//  Copyright © 2019 Li. All rights reserved.
//

import UIKit

class CreditTableViewController: UITableViewController {
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
    }
    
    override func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        
        return Constants.CREDIT_NAME_CELL.count
    }
    
    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = UITableViewCell()
        
        cell.textLabel?.text = Constants.CREDIT_NAME_CELL[indexPath.row]
        cell.accessoryType = .disclosureIndicator
        
        return cell
    }
    
    override func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        
        switch indexPath.row {
        case 0...2:
            let message = """
      К оплате: 30.7 руб
    Оплата до: 25.16.2019
    """
            let alert = UIAlertController(title: Constants.CREDIT_NAME_CELL[indexPath.row], message: message, preferredStyle: .alert)
            let action = UIAlertAction(title: "ОК", style: .default, handler: nil)
            alert.addAction(action)
            present(alert, animated: true, completion: nil)
        default:
            break
            //present(InfoPageTableViewController(index: 0), animated: true, completion: nil)
        }
    }
    
}


