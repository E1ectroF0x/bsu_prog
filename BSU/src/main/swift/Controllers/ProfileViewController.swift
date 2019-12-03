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
    
    var educationView = UITableView()
    var paymentsView = UITableView()
    var perfomanceView = UITableView()

    
    override func viewDidLoad() {
        super.viewDidLoad()
        self.title = "Личный кабинет"
        view.backgroundColor = UIColor.clear
        
        setUserImage(sender: userImage)
        setUserFIO(sender: userFIO)
        setSegmentControl(sender: userSegment)
        
        userSegment.addTarget(self, action: #selector(userChooseSegmentIndex), for: .valueChanged)
    }
    
    // MARK: - PRIVATE METHODS
    private func setUserImage(sender: UIImageView) {
        let frame = CGRect(x: 30, y: 156, width: 150, height: 150)
        sender.frame = frame
        sender.image = UIImage(named: "yakusheva")
        sender.layer.cornerRadius = sender.frame.size.height / 2
        sender.contentMode = .scaleToFill
        view.addSubview(sender)
    }
    
    private func setUserFIO(sender: UILabel) {
        let frame = CGRect(x: 200, y: 165, width: 150, height: 120)
        sender.frame = frame
        
        sender.textAlignment = .left
        sender.numberOfLines = 3
        sender.text = Constants.USER_NAME_STRING
        sender.font = UIFont.boldSystemFont(ofSize: 20)
        view.addSubview(sender)
    }
    
    private func setSegmentControl(sender: UISegmentedControl) {
        let frame = CGRect(x: 0, y: 350, width: view.frame.size.width, height: 70)
        sender.frame = frame
        view.addSubview(sender)
    }
    
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
