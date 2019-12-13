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
    
    let headerText = ["Текущий семестр", "Экзамены", "Зачеты"]
    

    override func viewDidLoad() {
        super.viewDidLoad()
        tableView.backgroundColor = .white
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
            cell.infoLabel.text = "10"
            return cell
            
        }
        else{
            let cell = tableView.dequeueReusableCell(withIdentifier: "TestProgressCell", for: indexPath) as! TestProgressCell
            cell.contentView.frame = CGRect(x: 20, y: 0, width: view.frame.width-40, height: 70)
            cell.infoNameLabel.text = data[indexPath.section][indexPath.row]
            cell.test = true
            cell.updateUI()
            return cell
        }
        
        
        
    }
    override func tableView(_ tableView: UITableView, viewForHeaderInSection section: Int) -> UIView? {
        let headerView = UIView.init(frame: CGRect.init(x: 0, y: 0, width: tableView.frame.width, height: 30))

        let label = UILabel()
        label.frame = CGRect(x: 20, y: 0, width: headerView.frame.width-40, height: headerView.frame.height)
        label.text = headerText[section]
        label.font = .boldSystemFont(ofSize: 20)
        label.textColor = UIColor(red: 20.0 / 255.0, green: 78.0 / 255.0, blue: 157.0 / 255.0, alpha: 1.0)

        headerView.addSubview(label)

        return headerView
    }
    
    override func tableView(_ tableView: UITableView, heightForHeaderInSection section: Int) -> CGFloat {
        return 30
    }

    
    override func tableView(_ tableView: UITableView, heightForRowAt indexPath: IndexPath) -> CGFloat {
        return 70
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
