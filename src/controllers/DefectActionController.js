const express = require("express");
const path = require("path");

const router = express.Router();

function showDefectActionPage(req, res) {
  res.sendFile(path.join(__dirname, "../views/check/defect-action.html"));
}

function submitDefectAction(req, res) {
  // TODO: 구현 및 단위시험 예정
}

router.get("/", showDefectActionPage);
router.post("/", submitDefectAction);

module.exports = router;