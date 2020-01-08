//
//  StartViewController.swift
//  tableSettigins
//
//  Created by Li on 1/6/20.
//  Copyright © 2020 Li. All rights reserved.
//

import UIKit

class StartViewController: UIViewController {

 
    @IBOutlet weak var loginTextField: UITextField!
    @IBOutlet weak var passwordTextField: UITextField!
    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
    }
    
    @IBAction func buttonTapped(_ sender: Any) {
        let login = Login(login: loginTextField.text ?? "", pass: passwordTextField.text ?? "")
        let api = ApiRequest(endpoint: "user/login")
        api.login(login) { (result) in
            print(result)

        }
        
    }
  

}
