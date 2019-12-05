//
//  SceneDelegate.swift
//  BSU
//
//  Created by Alexey Meleshkevich on 12/11/2019.
//  Copyright © 2019 Alexey Meleshkevich. All rights reserved.
//

import UIKit

class SceneDelegate: UIResponder, UIWindowSceneDelegate {
    
    var window: UIWindow?
    let tabBarController = UITabBarController()
    
    
    
    func scene(_ scene: UIScene, willConnectTo session: UISceneSession, options connectionOptions: UIScene.ConnectionOptions) {
        
        let profileVC = ProfileViewController()
        profileVC.title = "Личный кабинет"
        profileVC.view.backgroundColor = .white
        
        let calendarVC = CalendarViewController()
        calendarVC.title = "Календарь"
        calendarVC.view.backgroundColor = .white
        
        let settingsVC = SettingsViewController()
        settingsVC.title = "Настройки"
        settingsVC.view.backgroundColor = .white
        
        //нужно будет делать для выбранных изображений
        profileVC.tabBarItem = UITabBarItem(title: nil, image: UIImage(named: "user"), tag: 0)
        calendarVC.tabBarItem = UITabBarItem(title: nil, image: UIImage(named: "calendar"), tag: 1)
        settingsVC.tabBarItem = UITabBarItem(title: nil, image: UIImage(named: "gear"), selectedImage: UIImage(named: "fill_gear"))
        //settingsVC.tabBarItem = UITabBarItem(title: nil, image: UIImage(named: "gear"), tag: 2)
        
        let controllers = [profileVC, calendarVC, settingsVC]
        tabBarController.viewControllers = controllers
        
        tabBarController.viewControllers = controllers.map { UINavigationController(rootViewController: $0)}
       
        customNavigationController(with: controllers)
        
        tabBarController.tabBar.barTintColor = UIColor(red: 20.0 / 255.0, green: 78.0 / 255.0, blue: 157.0 / 255.0, alpha: 1.0)
        tabBarController.tabBar.tintColor = .white
        
        guard let windowScene = (scene as? UIWindowScene) else { return }
        
        self.window?.windowScene = windowScene
        self.window?.rootViewController = tabBarController
        self.window?.makeKeyAndVisible()
    
}

func sceneDidDisconnect(_ scene: UIScene) {
    // Called as the scene is being released by the system.
    // This occurs shortly after the scene enters the background, or when its session is discarded.
    // Release any resources associated with this scene that can be re-created the next time the scene connects.
    // The scene may re-connect later, as its session was not neccessarily discarded (see `application:didDiscardSceneSessions` instead).
}

func sceneDidBecomeActive(_ scene: UIScene) {
    // Called when the scene has moved from an inactive state to an active state.
    // Use this method to restart any tasks that were paused (or not yet started) when the scene was inactive.
}

func sceneWillResignActive(_ scene: UIScene) {
    // Called when the scene will move from an active state to an inactive state.
    // This may occur due to temporary interruptions (ex. an incoming phone call).
}

func sceneWillEnterForeground(_ scene: UIScene) {
    // Called as the scene transitions from the background to the foreground.
    // Use this method to undo the changes made on entering the background.
}

func sceneDidEnterBackground(_ scene: UIScene) {
    // Called as the scene transitions from the foreground to the background.
    // Use this method to save data, release shared resources, and store enough scene-specific state information
    // to restore the scene back to its current state.
}

    func customNavigationController(with VCs: [UIViewController]){
        
        for VC in VCs{
            VC.navigationController?.navigationBar.barTintColor = UIColor(red: 20.0 / 255.0, green: 78.0 / 255.0, blue: 157.0 / 255.0, alpha: 1.0)
            VC.navigationController?.navigationBar.titleTextAttributes = [NSAttributedString.Key.foregroundColor : UIColor.white]
        }
        
    }
}

