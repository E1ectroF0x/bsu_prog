//
//  SettingsViewController.swift
//  BSU
//
//  Created by Li on 12/2/19.
//  Copyright © 2019 Alexey Meleshkevich. All rights reserved.
//

import UIKit

class SettingsViewController: UIViewController, UITableViewDataSource, UITableViewDelegate{
    
    let tableView = UITableView(frame: .zero, style: .grouped)
    let backButton = UIBarButtonItem(image: UIImage(named: "inv_arrow"), style: .plain, target: self, action: #selector(buckButton(sender:)))
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        self.view.backgroundColor = UIColor.white
        
        self.backButton.tintColor = .white
        self.navigationItem.leftBarButtonItem = backButton
        
        self.tableView.register(SettingsTableViewCell.self, forCellReuseIdentifier: "SettingsCell")
        self.tableView.dataSource = self
        self.tableView.delegate = self
        
        self.navigationController!.navigationBar.barTintColor = UIColor(red: 20.0 / 255.0, green: 78.0 / 255.0, blue: 157.0 / 255.0, alpha: 1.0)
        self.navigationController!.navigationBar.titleTextAttributes = [NSAttributedString.Key.foregroundColor : UIColor.white]
        
        self.navigationItem.title = "Настройки"
        
        view.addSubview(tableView)
        
        updateLayout(with: self.view.frame.size)
        
    }
    
    private func updateLayout(with size : CGSize){
        self.tableView.frame = CGRect(origin: .zero, size: size)
    }
    
    
    @objc func buckButton(sender : UIBarButtonItem!){
        print("Sosat")
    }
    
    func tableView(_ tableView: UITableView, heightForHeaderInSection section: Int) -> CGFloat {
        return 0
    }
    
    func tableView(_ tableView: UITableView, viewForHeaderInSection section: Int) -> UIView? {
        let headerView = UIView.init(frame: CGRect.init(x: 0, y: 0, width: 0, height: 0))

        return headerView
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
        
        switch indexPath.row {
        case 4: cell.textLabel?.textColor = .systemBlue
        case 5: cell.textLabel?.textColor = .systemRed
        default: break
        }
        
        cell.imageView?.image = UIImage(named: Constants.SETTINGS_ICONS_NAME_CELL[indexPath.row])
        
        return cell
        
    }
    
}
