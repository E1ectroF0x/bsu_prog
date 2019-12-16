//
//  PageViewController.swift
//  ContainerVC
//
//  Created by Li on 12/10/19.
//  Copyright © 2019 Li. All rights reserved.
//

import UIKit

class PageViewController: UIPageViewController {
    
    let infoTableView = InfoPageTableViewController(style: .grouped)
    override func viewDidLoad() {
        super.viewDidLoad()
        setViewControllers([infoTableView], direction: .forward, animated: false, completion: nil)
    }
    
    func switchTableVC(index: Int) -> UITableViewController{
        switch index {
        case 0: return InfoPageTableViewController(style: .grouped)
        case 1: return CreditTableViewController(style: .grouped)
        case 2: return StudyProgressTableViewController(style: .grouped)
        default: return UITableViewController()
            
        }
    }
    
    func nextPageWithIndex(index: Int){
       let controller = switchTableVC(index: index)
           setViewControllers([controller], direction: .forward, animated: false, completion: nil)
       }
    
}

