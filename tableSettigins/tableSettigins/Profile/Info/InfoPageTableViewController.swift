//
//  ProfileTableViewController.swift
//  tableSettigins
//
//  Created by Li on 12/10/19.
//  Copyright © 2019 Li. All rights reserved.
//

import UIKit

class InfoPageTableViewController: UITableViewController {
    
    var profile = Profile() {
        didSet {
            tableView.reloadData()
        }
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        updateUI()
    }

    func updateUI() {
        tableView.backgroundColor = .white
        tableView.register(UITableViewCell.self, forCellReuseIdentifier: "UserInfoCell")
        tableView.allowsSelection = false
    }
    // MARK: - Table view data source
    
    override func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return Constants.USER_INFO_NAME_CELL.count
    }
    
    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = self.tableView.dequeueReusableCell(withIdentifier: "UserInfoCell", for: indexPath)
        cell.textLabel?.numberOfLines = 0
        cell.textLabel?.attributedText = makeAttributesString(title: Constants.USER_INFO_NAME_CELL[indexPath.row], subtitle: profile.getProperty(index: indexPath.row))

        return cell
    }
    
    override func tableView(_ tableView: UITableView, viewForHeaderInSection section: Int) -> UIView? {
        let headerView = UIView.init(frame: CGRect.init(x: 0, y: 0, width: 0, height: 0))
        
        return headerView
    }
    
    override func tableView(_ tableView: UITableView, heightForHeaderInSection section: Int) -> CGFloat {
        return 0
    }
    
    // MARK: -Function
    
    func makeAttributesString(title: String, subtitle: String) -> NSAttributedString {
        let titleAttributes = [NSAttributedString.Key.font: UIFont.preferredFont(forTextStyle: .headline)]
        let subtitleAttributes = [NSAttributedString.Key.font: UIFont.preferredFont(forTextStyle: .subheadline)]
        let titleString = NSMutableAttributedString(string: "\(title):\n", attributes: titleAttributes)
        let subtitleString = NSAttributedString(string: subtitle, attributes: subtitleAttributes)
        
        titleString.append(subtitleString)
        return titleString
    }
    
}
