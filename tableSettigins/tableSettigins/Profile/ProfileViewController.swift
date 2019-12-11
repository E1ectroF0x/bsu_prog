//
//  ProfileViewController.swift
//  BSU
//
//  Created by Alexey Meleshkevich on 26/11/2019.
//  Copyright © 2019 Alexey Meleshkevich. All rights reserved.
//

import UIKit

class ProfileViewController: UIViewController {
    
    
    @IBOutlet weak var avatar: UIImageView!
    @IBOutlet weak var nameLabel: UILabel!
    @IBOutlet weak var segment: UISegmentedControl!
    
    override func viewDidLoad() {
        super.viewDidLoad()
       
    }
    
    @IBAction func changeTableView(_ sender: UISegmentedControl) {
        
        let pageViewController = self.children[0] as! PageViewController
        pageViewController.nextPageWithIndex(index: sender.selectedSegmentIndex)
    }
    
}
