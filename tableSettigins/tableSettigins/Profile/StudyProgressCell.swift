//
//  UserInfoCell.swift
//  tableSettigins
//
//  Created by Li on 12/5/19.
//  Copyright © 2019 Li. All rights reserved.
//

import UIKit


class StudyProgressCell: UITableViewCell {
    
    let infoNameLabel : UILabel = {
        let lbl = UILabel()
        lbl.textColor = .black
        lbl.font = UIFont.systemFont(ofSize: 16)
        lbl.textAlignment = .left
        lbl.numberOfLines = 0
        return lbl
    }()
    let infoLabel : UILabel = {
        let lbl = UILabel()
        lbl.textColor = .systemBlue
        lbl.font = UIFont.boldSystemFont(ofSize: 20)
        lbl.textAlignment = .right
        lbl.numberOfLines = 0
        return lbl
    }()
    
    override init(style: UITableViewCell.CellStyle, reuseIdentifier: String?) {
        super.init(style: style, reuseIdentifier: reuseIdentifier)
        updateUI()
    }
    
    func updateUI(){
        let stackView = UIStackView(arrangedSubviews: [infoNameLabel, infoLabel])
        stackView.alignment = .center
        stackView.distribution = .equalCentering
        stackView.axis = .horizontal
        
        stackView.frame = contentView.frame
        
        
        infoNameLabel.translatesAutoresizingMaskIntoConstraints = false
        infoLabel.translatesAutoresizingMaskIntoConstraints = false
        let constraint =
            NSLayoutConstraint(item: infoNameLabel, attribute: NSLayoutConstraint.Attribute.width, relatedBy: NSLayoutConstraint.Relation.greaterThanOrEqual, toItem: nil, attribute: NSLayoutConstraint.Attribute.notAnAttribute, multiplier: 1, constant: 250)
        stackView.addConstraint(constraint)
        contentView.addSubview(stackView)
    }
    
    required init?(coder: NSCoder) {
        fatalError("init(coder:) has not been implemented")
    }
    
    override func awakeFromNib() {
        super.awakeFromNib()
        
        
    }
    
    
    override func setSelected(_ selected: Bool, animated: Bool) {
        super.setSelected(selected, animated: animated)
        
        // Configure the view for the selected state
    }
    
}
