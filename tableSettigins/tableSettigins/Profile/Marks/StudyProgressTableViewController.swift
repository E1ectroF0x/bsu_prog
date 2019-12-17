//
//  StudyProgressTableViewController.swift
//  tableSettigins
//
//  Created by Li on 12/10/19.
//  Copyright © 2019 Li. All rights reserved.
//

import UIKit

class StudyProgressTableViewController: UITableViewController {
    
    let data = [[],["Математический анализ",
                    "Общая физика",
                    "Численные методы",
                    "Дифференциальные уравнения",
                    "Теория вероятностей и математическая статистика"],
                ["Математический анализ",
                 "Общая физика",
                 "Численные методы",
                 "Имитационное и статистическое моделирование",
                 "Прикладное программирование",
                 "Физическая культура"]]
    
    let headerText = ["Выбрать семестр", "Экзамены", "Зачеты"]

    let childPicker = PickerViewController()
    
    override func viewDidLoad() {
        super.viewDidLoad()
        updateUI()
    }
    
    func updateUI() {
        tableView.allowsSelection = false
        tableView.register(ExamProgressCell.self, forCellReuseIdentifier: "ExamProgressCell")
        tableView.register(TestProgressCell.self, forCellReuseIdentifier: "TestProgressCell")
    }
    // MARK: - Table view data source
    
    override func numberOfSections(in tableView: UITableView) -> Int {
        // #warning Incomplete implementation, return the number of sections
        return data.count
    }
    
    override func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        
        return data[section].count
    }
    
    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        
        if indexPath.section == 1 {
            let cell = tableView.dequeueReusableCell(withIdentifier: "ExamProgressCell", for: indexPath) as! ExamProgressCell
            cell.contentView.frame = CGRect(x: 20, y: 0, width: view.frame.width-40, height: 70)
            cell.updateUI()
            cell.infoNameLabel.text = data[indexPath.section][indexPath.row]
            cell.infoLabel.text = "4"
            
            return cell
            
        }
        else{
            let cell = tableView.dequeueReusableCell(withIdentifier: "TestProgressCell", for: indexPath) as! TestProgressCell
            cell.contentView.frame = CGRect(x: 20, y: 0, width: view.frame.width-40, height: 70)
            cell.infoNameLabel.text = data[indexPath.section][indexPath.row]
            cell.test = false
            cell.updateUI()
            
            return cell
        }
        
        
        
    }
    override func tableView(_ tableView: UITableView, viewForHeaderInSection section: Int) -> UIView? {
        
        if section == 0 {
            let headerView = SelectView(frame: CGRect.init(x: 0, y: 0, width: tableView.frame.width, height: 55))
            headerView.label.text = headerText[section]
            
            let gesture = UITapGestureRecognizer(target: self, action: #selector(showPicker(sender:)))
            headerView.addGestureRecognizer(gesture)
            
            return headerView
        }
        else {
            let headerView = UIView.init(frame: CGRect.init(x: 0, y: 0, width: tableView.frame.width, height: 55))
            
            let label = UILabel()
            label.frame = CGRect(x: 20, y: 0, width: headerView.frame.width-40, height: headerView.frame.height)
            label.text = headerText[section]
            label.font = .systemFont(ofSize: 17)
            label.textColor = .systemGray
            
            headerView.addSubview(label)
            return headerView
        }
        
        
        
    }
    
    override func tableView(_ tableView: UITableView, heightForHeaderInSection section: Int) -> CGFloat {
        return 55
    }
    
    override func tableView(_ tableView: UITableView, viewForFooterInSection section: Int) -> UIView? {
        let footerView = UIView.init(frame: CGRect.init(x: 0, y: 0, width: 0, height: 0))
        
        return footerView
    }
    
    override func tableView(_ tableView: UITableView, heightForFooterInSection section: Int) -> CGFloat {
        
        return 0
    }
    override func tableView(_ tableView: UITableView, heightForRowAt indexPath: IndexPath) -> CGFloat {
        
        return 70
    }
    
    @objc func showPicker(sender: UITapGestureRecognizer) {
        tableView.isScrollEnabled = false
        addChild(childPicker)
        view.addSubview(childPicker.view)
        childPicker.picker.selectRow(2, inComponent: 0, animated: false)
        let offset = self.tableView.contentOffset
        childPicker.view.frame = CGRect(x: 0, y: tableView.frame.maxY - 244 + offset.y, width: tableView.frame.width, height: 244)
        childPicker.updateUI()
        childPicker.didMove(toParent: self)
    }
    /*
     // Override to support conditional editing of the table view.
     override func tableView(_ tableView: UITableView, canEditRowAt indexPath: IndexPath) -> Bool {
     // Return false if you do not want the specified item to be editable.
     return true
     }
     */
    
    /*
     // Override to support editing the table view.
     override func tableView(_ tableView: UITableView, commit editingStyle: UITableViewCell.EditingStyle, forRowAt indexPath: IndexPath) {
     if editingStyle == .delete {
     // Delete the row from the data source
     tableView.deleteRows(at: [indexPath], with: .fade)
     } else if editingStyle == .insert {
     // Create a new instance of the appropriate class, insert it into the array, and add a new row to the table view
     }
     }
     */
    
    /*
     // Override to support rearranging the table view.
     override func tableView(_ tableView: UITableView, moveRowAt fromIndexPath: IndexPath, to: IndexPath) {
     
     }
     */
    
    /*
     // Override to support conditional rearranging of the table view.
     override func tableView(_ tableView: UITableView, canMoveRowAt indexPath: IndexPath) -> Bool {
     // Return false if you do not want the item to be re-orderable.
     return true
     }
     */
    
    /*
     // MARK: - Navigation
     
     // In a storyboard-based application, you will often want to do a little preparation before navigation
     override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
     // Get the new view controller using segue.destination.
     // Pass the selected object to the new view controller.
     }
     */
    
}
