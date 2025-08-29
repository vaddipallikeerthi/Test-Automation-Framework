# 🚀 Test Automation Framework

This is a **Java-based Test Automation Framework** designed for UI test automation.  
It supports **parallel execution**, **cloud testing with LambdaTest**, **reporting**, and integrates with **CI/CD pipelines** via GitHub Actions.

---

## 🔹 Tech Stack
- **Language**: Java 11
- **Testing Framework**: TestNG
- **Build Tool**: Maven
- **Cloud Testing**: [LambdaTest](https://www.lambdatest.com/)
- **Parallel Execution**: TestNG + Surefire plugin
- **Logging**: Log4j
- **Reporting**: Extent Reports
- **Utilities**:
  - OpenCSV (for CSV data handling)
  - Apache POI (for Excel data handling)

---

## 🔹 Features
✅ Run tests on **local browsers** or on **LambdaTest cloud grid**  
✅ **Parallel execution** support for faster test runs  
✅ **Cross-browser testing** (Chrome, Firefox, Edge, etc.)  
✅ **Data-driven testing** using CSV & Excel  
✅ **Logging** with Log4j  
✅ **Rich test reports** using Extent Reports  
✅ Integrated with **GitHub Actions CI/CD**  
✅ Supports **Maven Surefire plugin** for easy execution  

---

## 🔹 Project Structure
Test-Automation-Framework/ ├── src/main/java/com/... # Framework core utilities ├── src/test/java/com/... # Test classes ├── logs/ # Execution logs ├── Report.html # Extent report (generated after run) ├── pom.xml # Maven dependencies & plugins └── .github/workflows/ci.yml # GitHub Actions workflow


---

## 🔹 Prerequisites
- Install **Java 11**
- Install **Maven 3+**
- Create a **LambdaTest account** (get username & access key)

Set your LambdaTest credentials in environment variables:
```bash
export LT_USERNAME="your_username"
export LT_ACCESS_KEY="your_access_key"
(For Windows: use set instead of export)

🔹 How to Run Tests
▶️ Run Locally
Clone the repo:

git clone https://github.com/<your-username>/Test-Automation-Framework.git
cd Test-Automation-Framework
Run tests:

mvn clean test
▶️ Run via GitHub Actions
This project includes a workflow (.github/workflows/ci.yml) to run tests on every push or manually.

Go to Actions tab in GitHub.
Select Test Automation Framework workflow.
Click Run workflow.
🔹 Future Enhancements
Add API testing support
Integrate with Allure reports
Dockerize framework for containerized execution
📌 Author
👤 Keerthi V 📧 keerthi.ashokvaddipalli@gmail.com 🔗 LinkedIn
