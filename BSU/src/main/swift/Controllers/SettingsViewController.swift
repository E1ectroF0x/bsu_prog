//
//  SettingsViewController.swift
//  BSU
//
//  Created by Li on 12/2/19.
//  Copyright © 2019 Alexey Meleshkevich. All rights reserved.
//

import UIKit

class SettingsViewController: UIViewController, UITableViewDataSource{
    
    let tableView = UITableView(frame: .zero, style: .grouped)
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        self.view.backgroundColor = UIColor.white
        
        self.tableView.register(SettingsTableViewCell.self, forCellReuseIdentifier: "SettingsCell")
        self.tableView.dataSource = self
        
        self.navigationController!.navigationBar.barTintColor = UIColor(red: 20.0 / 255.0, green: 78.0 / 255.0, blue: 157.0 / 255.0, alpha: 1.0)
        self.navigationController!.navigationBar.titleTextAttributes = [NSAttributedString.Key.foregroundColor : UIColor.white]
        
        self.navigationItem.title = "Настройки"
        
        view.addSubview(tableView)
        
        updateLayout(with: self.view.frame.size)
        
    }
    
    private func updateLayout(with size : CGSize){
        self.tableView.frame = CGRect(origin: .zero, size: size)
    }
    
    
    
    
    
    
    
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return Constants.SETTINGS_NAME_CELL.count
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = self.tableView.dequeueReusableCell(withIdentifier: "SettingsCell", for: indexPath) as! SettingsTableViewCell
        cell.textLabel?.text = Constants.SETTINGS_NAME_CELL[indexPath.row]
        
        switch indexPath.row {
        case 0...4: cell.accessoryType = .disclosureIndicator
        default: break
        }
        cell.imageView?.image = UIImage(named: Constants.SETTINGS_ICONS_NAME_CELL[indexPath.row])
        
        return cell
        
    }
    
}
