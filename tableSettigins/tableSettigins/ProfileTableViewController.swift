//
//  ProfileTableViewController.swift
//  tableSettigins
//
//  Created by Li on 12/10/19.
//  Copyright © 2019 Li. All rights reserved.
//

import UIKit

class ProfileTableViewController: UITableViewController {

    var index : Int = 0
        let numberOfRowsInSection = [7,4,3]
        override func viewDidLoad() {
            super.viewDidLoad()

        }

        init(index : Int) {
            super.init(style: .plain)
            self.index = index
        }
        
        required init?(coder: NSCoder) {
            fatalError("init(coder:) has not been implemented")
        }
        // MARK: - Table view data source

        override func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
           
            return numberOfRowsInSection[index]
        }
        
        override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
            let cell = UITableViewCell()
            
            switch index {
            case 0: cell.textLabel?.text = Constants.USER_INFO_NAME_CELL[indexPath.row]
            case 1:
                cell.textLabel?.text = Constants.CREDIT_NAME_CELL[indexPath.row]
                cell.accessoryType = .disclosureIndicator
            default: cell.textLabel?.text = "\(indexPath.row)"
            }
          
            return cell
        }
        
        override func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
            if index == 1 {
                switch indexPath.row {
                case 0...2:
                    let message = """
      К оплате: 30.7 руб
    Оплата до: 25.16.2019
    """
                    let alert = UIAlertController(title: Constants.CREDIT_NAME_CELL[indexPath.row], message: message, preferredStyle: .alert)
                    let action = UIAlertAction(title: "Ok", style: .default, handler: nil)
                    alert.addAction(action)
                    present(alert, animated: true, completion: nil)
                default:
                    present(ProfileTableViewController(index: 0), animated: true, completion: nil)
                }
            }
               
           }
        /*
        // Override to support conditional editing of the table view.
        override func tableView(_ tableView: UITableView, canEditRowAt indexPath: IndexPath) -> Bool {
            // Return false if you do not want the specified item to be editable.
            return true
        }
        */

        /*
        // Override to support editing the table view.
        override func tableView(_ tableView: UITableView, commit editingStyle: UITableViewCell.EditingStyle, forRowAt indexPath: IndexPath) {
            if editingStyle == .delete {
                // Delete the row from the data source
                tableView.deleteRows(at: [indexPath], with: .fade)
            } else if editingStyle == .insert {
                // Create a new instance of the appropriate class, insert it into the array, and add a new row to the table view
            }
        }
        */

        /*
        // Override to support rearranging the table view.
        override func tableView(_ tableView: UITableView, moveRowAt fromIndexPath: IndexPath, to: IndexPath) {

        }
        */

        /*
        // Override to support conditional rearranging of the table view.
        override func tableView(_ tableView: UITableView, canMoveRowAt indexPath: IndexPath) -> Bool {
            // Return false if you do not want the item to be re-orderable.
            return true
        }
        */

        /*
        // MARK: - Navigation

        // In a storyboard-based application, you will often want to do a little preparation before navigation
        override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
            // Get the new view controller using segue.destination.
            // Pass the selected object to the new view controller.
        }
        */

    }
