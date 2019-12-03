//
//  TabBarViewController.swift
//  BSU
//
//  Created by Li on 12/3/19.
//  Copyright © 2019 Alexey Meleshkevich. All rights reserved.
//

import UIKit

class TabBarViewController: UITabBarController, UITabBarControllerDelegate {

    override func viewDidLoad() {
        super.viewDidLoad()
        
       // self.tabBarController?.tabBar.barTintColor = UIColor(red: 20.0 / 255.0, green: 78.0 / 255.0, blue: 157.0 / 255.0, alpha: 1.0)
       
        let tabBarController = UITabBarController()
        
        
        let settingsVC = SettingsViewController()
        settingsVC.view.backgroundColor = .white
     
       // let calendarVC = CalendarViewController()
        //let profileVC = ProfileViewController()
        //profileVC.view.backgroundColor = .white
        //calendarVC.view.backgroundColor = .white
        
       // profileVC.tabBarItem = UITabBarItem(title: nil, image: UIImage(named: "user"), tag: 0)
       // calendarVC.tabBarItem = UITabBarItem(title: nil, image: UIImage(named: "calendar"), tag: 1)
        settingsVC.tabBarItem = UITabBarItem(title: nil, image: UIImage(named: "gear"), tag: 2)
        let controllers = [settingsVC]
        //let controllers = [settingsVC, calendarVC, profileVC]
        tabBarController.viewControllers = controllers
        tabBarController.viewControllers = controllers.map { UINavigationController(rootViewController: $0)}
        
    }
    
    

}
