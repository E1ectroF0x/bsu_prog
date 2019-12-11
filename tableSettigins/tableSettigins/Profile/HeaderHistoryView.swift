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
        lbl.font = UIFont.systemFont(ofSize: 17)
        lbl.textAlignment = .left
        lbl.numberOfLines = 0
        lbl.text = "Тип платежа"
        return lbl
    }()
    let amountLabel : UILabel = {
        let lbl = UILabel()
        lbl.textColor = .black
        lbl.font = UIFont.systemFont(ofSize: 17)
        lbl.textAlignment = .center
        lbl.numberOfLines = 0
        lbl.text = "Сумма оплаты"
        return lbl
    }()
    
    let dateLabel : UILabel = {
        let lbl = UILabel()
        lbl.textColor = .black
        lbl.font = UIFont.systemFont(ofSize: 17)
        lbl.textAlignment = .right
        lbl.numberOfLines = 0
        lbl.text = "Дата"
        return lbl
    }()
   
    override init(frame: CGRect) {
        super.init(frame: frame)
        backgroundColor = .white
        
        let stackView = UIStackView(arrangedSubviews: [typeLabel, amountLabel, dateLabel])
        stackView.distribution = .fillProportionally
        stackView.alignment = .fill
        stackView.axis = .horizontal
        stackView.frame = frame
        
//        let blackLine = UIView(frame: CGRect(x: 0, y: 44, width: frame.width + 40, height: 1))
//        blackLine.backgroundColor = .black
//        let fullStackView = UIStackView(arrangedSubviews: [stackView, blackLine])
//        fullStackView.axis = .vertical
//        fullStackView.frame = frame
        
        addSubview(stackView)
    }
    
    required init?(coder: NSCoder) {
        fatalError("init(coder:) has not been implemented")
    }
    override func draw(_ rect: CGRect) {
        
    }
   

}
