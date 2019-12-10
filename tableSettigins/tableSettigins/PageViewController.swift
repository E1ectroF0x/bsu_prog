//
//  PageViewController.swift
//  ContainerVC
//
//  Created by Li on 12/10/19.
//  Copyright © 2019 Li. All rights reserved.
//

import UIKit

class PageViewController: UIPageViewController {
    
    let infoTableView = InfoPageTableViewController()
    override func viewDidLoad() {
        super.viewDidLoad()
        setViewControllers([infoTableView], direction: .forward, animated: false, completion: nil)
    }
    
    func switchTableVC(index: Int) -> UITableViewController{
        switch index {
        case 0: return InfoPageTableViewController()
        case 1: return CreditTableViewController()
        case 2: return StudyProgressTableViewController()
       
            
        default: return UITableViewController()
            
        }
    }
    
    func nextPageWithIndex(index: Int){
       let controller = switchTableVC(index: index)
           setViewControllers([controller], direction: .forward, animated: false, completion: nil)

       }
    
}

