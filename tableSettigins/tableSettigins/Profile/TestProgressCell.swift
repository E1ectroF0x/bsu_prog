//
//  UserInfoCell.swift
//  tableSettigins
//
//  Created by Li on 12/5/19.
//  Copyright © 2019 Li. All rights reserved.
//

import UIKit


class TestProgressCell: UITableViewCell {
    
    let infoNameLabel : UILabel = {
        let lbl = UILabel()
        lbl.textColor = .black
        lbl.font = UIFont.systemFont(ofSize: 16)
        lbl.textAlignment = .left
        lbl.numberOfLines = 0
        return lbl
    }()
    
    let Image : UIImageView = {
        let view = UIImageView()
        view.tintColor = UIColor(red: 20.0 / 255.0, green: 78.0 / 255.0, blue: 157.0 / 255.0, alpha: 1.0)
        view.translatesAutoresizingMaskIntoConstraints = false
        let widthConstraint =
        NSLayoutConstraint(item: view, attribute: NSLayoutConstraint.Attribute.width, relatedBy: NSLayoutConstraint.Relation.greaterThanOrEqual, toItem: nil, attribute: NSLayoutConstraint.Attribute.notAnAttribute, multiplier: 1, constant: 24)
        let heightConstraint =
        NSLayoutConstraint(item: view, attribute: NSLayoutConstraint.Attribute.height, relatedBy: NSLayoutConstraint.Relation.greaterThanOrEqual, toItem: nil, attribute: NSLayoutConstraint.Attribute.notAnAttribute, multiplier: 1, constant: 24)
        view.addConstraints([widthConstraint,heightConstraint])
        return view
    }()
    
    var test = false
    
    override init(style: UITableViewCell.CellStyle, reuseIdentifier: String?) {
        super.init(style: style, reuseIdentifier: reuseIdentifier)
        updateUI()
    }
    
    func updateUI(){
        if test {
            Image.image = UIImage(systemName: "plus")
        }
        else {
            Image.image = UIImage(systemName: "minus")
        }
        let stackView = UIStackView(arrangedSubviews: [infoNameLabel, Image])
        stackView.alignment = .center
        stackView.distribution = .equalCentering
        stackView.axis = .horizontal
        stackView.frame = contentView.frame
        
        
        infoNameLabel.translatesAutoresizingMaskIntoConstraints = false
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
