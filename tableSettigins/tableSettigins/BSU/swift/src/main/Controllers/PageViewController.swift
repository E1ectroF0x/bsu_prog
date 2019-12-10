//
//  PageViewController.swift
//  ContainerVC
//
//  Created by Li on 12/10/19.
//  Copyright © 2019 Li. All rights reserved.
//

import UIKit

class PageViewController: UIPageViewController {
    
    let infoTableView = ProfileTableViewController(index: 0)
    override func viewDidLoad() {
        super.viewDidLoad()
        setViewControllers([infoTableView], direction: .forward, animated: false, completion: nil)
    }
    
}

extension PageViewController: UIPageViewControllerDataSource {
    func pageViewController(_ pageViewController: UIPageViewController, viewControllerBefore viewController: UIViewController) -> UIViewController? {
        let index = (viewController as! ProfileTableViewController).index - 1
        if index < 0 {
            return nil
        }
        return ProfileTableViewController(index: index)
    }
    
    func pageViewController(_ pageViewController: UIPageViewController, viewControllerAfter viewController: UIViewController) -> UIViewController? {
        let index = (viewController as! ProfileTableViewController).index + 1
        if index > 2 {
            return nil
        }
        return ProfileTableViewController(index: index)
    }
    
    func nextPageWithIndex(index: Int){
        setViewControllers([ProfileTableViewController(index: index)], direction: .forward, animated: false, completion: nil)

    }
    
}
