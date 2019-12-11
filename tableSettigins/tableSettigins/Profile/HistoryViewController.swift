//
//  HistoryViewController.swift
//  tableSettigins
//
//  Created by Li on 12/11/19.
//  Copyright © 2019 Li. All rights reserved.
//

import UIKit

class HistoryViewController: UIViewController {

    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        updateUI()
    }
    
    private func updateUI() {
        
        view.backgroundColor = .white
        navigationItem.title = "История платежей"
    
    }

}
