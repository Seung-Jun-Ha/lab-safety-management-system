const express = require("express");
const path = require("path");

const indexController = require("./src/controllers/indexController");
const registerController = require("./src/controllers/RegisterController");
const loginController = require("./src/controllers/LoginController");
const labInformationController = require("./src/controllers/LabInformationController");
const safetyRatingController = require("./src/controllers/SafetyRatingController");
const chemicalController = require("./src/controllers/ChemicalController");
const importApprovalController = require("./src/controllers/ImportApprovalController");
const wasteController = require("./src/controllers/WasteController");
const labCheckController = require("./src/controllers/LabCheckController");
const defectActionController = require("./src/controllers/DefectActionController");
const safetyEducationController = require("./src/controllers/SafetyEducationController");
const warningController = require("./src/controllers/WarningController");

const app = express();
const port = process.env.PORT || 3000;

app.use(express.urlencoded({ extended: false }));
app.use(express.json());
app.use("/views", express.static(path.join(__dirname, "src/views")));

app.use("/", indexController);
app.use("/auth/register", registerController);
app.use("/auth/login", loginController);
app.use("/lab/register", labInformationController);
app.use("/lab/safety-rating", safetyRatingController);
app.use("/chemical/register", chemicalController);
app.use("/chemical/approval", importApprovalController);
app.use("/waste", wasteController);
app.use("/check/daily", labCheckController);
app.use("/check/defect-action", defectActionController);
app.use("/education/confirm", safetyEducationController);
app.use("/education/warning", warningController);

if (require.main === module) {
  app.listen(port, () => {
    console.log(`Laboratory Safety Management System running on port ${port}`);
  });
}

module.exports = app;
