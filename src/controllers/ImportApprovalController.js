const express = require("express");
const path = require("path");

const router = express.Router();

function showImportApprovalPage(req, res) {
  res.sendFile(path.join(__dirname, "../views/chemical/approval.html"));
}

function submitImportApproval(req, res) {
  // TODO: 구현 및 단위시험 예정
}

router.get("/", showImportApprovalPage);
router.post("/", submitImportApproval);

module.exports = router;