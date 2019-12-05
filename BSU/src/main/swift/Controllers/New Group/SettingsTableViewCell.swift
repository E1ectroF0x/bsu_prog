//
//  SettingsTableViewCell.swift
//  BSU
//
//  Created by Li on 12/3/19.
//  Copyright © 2019 Alexey Meleshkevich. All rights reserved.
//

import UIKit

class SettingsTableViewCell: UITableViewCell {
    
    var button = UIButton()
    
    
    override func awakeFromNib() {
        super.awakeFromNib()
        
       // self.button.addTarget(self, action: #selector(presentVC(sender:)), for: .touchUpInside)
    }
    
    override func setSelected(_ selected: Bool, animated: Bool) {
        super.setSelected(selected, animated: animated)
        
        
    }
    
    
    
}
