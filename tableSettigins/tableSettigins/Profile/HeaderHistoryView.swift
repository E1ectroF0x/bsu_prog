//
//  HeaderHistoryView.swift
//  tableSettigins
//
//  Created by Li on 12/12/19.
//  Copyright © 2019 Li. All rights reserved.
//

import UIKit

class HeaderHistoryView: UIView {

    
    let typeLabel : UILabel = {
        let lbl = UILabel()
        lbl.textColor = .black
        lbl.font = UIFont.systemFont(ofSize: 16)
        lbl.textAlignment = .left
        lbl.numberOfLines = 1
        lbl.text = "Платеж"
        return lbl
    }()
    let amountLabel : UILabel = {
        let lbl = UILabel()
        lbl.textColor = .black
        lbl.font = UIFont.systemFont(ofSize: 16)
        lbl.textAlignment = .center
        lbl.numberOfLines = 1
        lbl.text = "Сумма оплаты"
        return lbl
    }()
    
    let dateLabel : UILabel = {
        let lbl = UILabel()
        lbl.textColor = .black
        lbl.font = UIFont.systemFont(ofSize: 16)
        lbl.textAlignment = .right
        lbl.numberOfLines = 1
        lbl.text = "Дата"
        return lbl
    }()
   
    override init(frame: CGRect) {
        super.init(frame: frame)
        backgroundColor = .white
        
        let stackView = UIStackView(arrangedSubviews: [typeLabel, amountLabel, dateLabel])
        stackView.distribution = .equalCentering
        stackView.alignment = .fill
        stackView.axis = .horizontal
        stackView.frame = frame
        
        let blackLine = UIImageView(frame: CGRect(origin: .zero, size: CGSize(width: frame.width + 40, height: 0.5)))
        blackLine.backgroundColor = .black
        blackLine.translatesAutoresizingMaskIntoConstraints = false
       let fullStackView = UIStackView(arrangedSubviews: [stackView, blackLine])
        fullStackView.axis = .vertical
        fullStackView.distribution = .fill
        fullStackView.spacing = 1
        fullStackView.frame = frame
        
        let views = ["blackLine" : blackLine, "stackView" : stackView]
        let constraint =  NSLayoutConstraint.constraints(withVisualFormat: "V:[stackView]-[blackLine(1)]", options: NSLayoutConstraint.FormatOptions.alignAllCenterX, metrics: nil, views: views)
        NSLayoutConstraint.activate(constraint)
        
        addSubview(fullStackView)
    }
    
    required init?(coder: NSCoder) {
        fatalError("init(coder:) has not been implemented")
    }
    override func draw(_ rect: CGRect) {
        
    }
   

}
