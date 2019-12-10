//
//  ProfileViewController.swift
//  BSU
//
//  Created by Alexey Meleshkevich on 26/11/2019.
//  Copyright © 2019 Alexey Meleshkevich. All rights reserved.
//

import UIKit

class ProfileViewController: UIViewController {
    
    let userImage = UIImageView()
    var userFIO = UILabel()
    var userSegment = UISegmentedControl(items: Constants.SEGMENT_SET_ITEMS as [Any])
    
    let educationTableView = UITableView(frame: .zero, style: .grouped)
    var paymentsView = UITableView()
    var perfomanceView = UITableView()

    
    override func viewDidLoad() {
        super.viewDidLoad()
        self.title = "Личный кабинет"
        view.backgroundColor = UIColor.clear
        
        setUserImage(sender: userImage)
        setUserFIO(sender: userFIO)
       // setSegmentControl(sender: userSegment)
        
        self.educationTableView.register(SettingsTableViewCell.self, forCellReuseIdentifier: "SettingsCell")
        
        self.educationTableView.dataSource = self
        self.educationTableView.delegate = self
        self.educationtableView.frame = CGRect(origin: .zero, size: size)
        
        self.view.addSubview(educationTableView)
        
        userSegment.addTarget(self, action: #selector(userChooseSegmentIndex), for: .valueChanged)
    }
    
    // MARK: - PRIVATE METHODS
    private func setUserImage(sender: UIImageView) {
        let frame = CGRect(x: 30, y: 75, width: 150, height: 150)
        sender.frame = frame
        sender.image = UIImage(named: "yakusheva")
        sender.layer.cornerRadius = sender.frame.size.height / 2
        sender.contentMode = .scaleToFill
        view.addSubview(sender)
    }
    
    private func setUserFIO(sender: UILabel) {
        let frame = CGRect(x: 200, y: 84, width: 150, height: 120)
        sender.frame = frame
        
        sender.textAlignment = .left
        sender.numberOfLines = 3
        sender.text = Constants.USER_NAME_STRING
        sender.font = UIFont.boldSystemFont(ofSize: 20)
        view.addSubview(sender)
    }
    
//    private func setSegmentControl(sender: UISegmentedControl) {
//        let frame = CGRect(x: 0, y: 350, width: view.frame.size.width, height: 70)
//        sender.frame = frame
//        view.addSubview(sender)
//    }
    
    // MARK: - ACTIONS
    @objc func userChooseSegmentIndex(target: UISegmentedControl) {
        if target == self.userSegment {
            let segmentIndex = target.selectedSegmentIndex
            
            switch segmentIndex {
            case 0:
                print("selected user view 1")
            case 1:
                print("selected user view 2")
            case 2:
                print("selected user view 3")
            default:
                break
            }
        }
    }
    
}

extension ProfileViewController: UITableViewDataSource, UITableViewDelegate{
    
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
    
    func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        //self.present(mainVC, animated: true, completion: nil)
    }
}
