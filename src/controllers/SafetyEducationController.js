const express = require("express");
const path = require("path");

const router = express.Router();

function showSafetyEducationConfirmPage(req, res) {
  res.sendFile(path.join(__dirname, "../views/education/confirm.html"));
}

function submitSafetyEducationConfirm(req, res) {
  // TODO: 구현 및 단위시험 예정
}

router.get("/", showSafetyEducationConfirmPage);
router.post("/", submitSafetyEducationConfirm);

module.exports = router;