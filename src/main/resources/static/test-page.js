const PAGE_CONFIGS = {
  'user-register': {
    title: '사용자 등록 신청',
    description: '/api/user/register 로 POST를 보냅니다.',
    api: '/api/user/register',
    mode: 'json',
    fields: [
      { name: 'name', label: '이름', type: 'text', placeholder: '홍길동' },
      { name: 'deptId', label: '부서 ID', type: 'text', placeholder: 'DPT-01' },
      { name: 'email', label: '이메일', type: 'email', placeholder: 'user@example.com' },
    ],
  },
  'user-search': {
    title: '사용자 조회',
    description: '/api/user/search 로 조회합니다.',
    api: '/api/user/search',
    mode: 'query',
    fields: [
      { name: 'name', label: '이름', type: 'text', placeholder: '홍길동' },
      { name: 'role', label: '역할', type: 'text', placeholder: 'USER' },
    ],
  },
  'lab-register': {
    title: '연구실 기본정보 등록',
    description: '/api/lab/register 로 POST를 보냅니다.',
    api: '/api/lab/register',
    mode: 'json',
    fields: [
      { name: 'labName', label: '연구실 이름', type: 'text', placeholder: '화학실험실' },
      { name: 'buildingId', label: '건물 ID', type: 'text', placeholder: 'B-101' },
      { name: 'floor', label: '층수', type: 'number', placeholder: '3', coerce: 'number' },
      { name: 'type', label: '유형', type: 'text', placeholder: '교육연구' },
      { name: 'inspectionTarget', label: '점검 대상 여부', type: 'select', options: ['true', 'false'], coerce: 'boolean' },
    ],
  },
  'lab-search': {
    title: '연구실 기본정보 조회',
    description: '/api/lab/search 로 조회합니다.',
    api: '/api/lab/search',
    mode: 'query',
    fields: [
      { name: 'labName', label: '연구실 이름', type: 'text', placeholder: '화학실험실' },
      { name: 'type', label: '유형', type: 'text', placeholder: '교육연구' },
      { name: 'buildingId', label: '건물 ID', type: 'text', placeholder: 'B-101' },
    ],
  },
  'chemical-register': {
    title: '시약 재고 등록',
    description: '/api/chemical/stock/register 로 POST를 보냅니다.',
    api: '/api/chemical/stock/register',
    mode: 'json',
    fields: [
      { name: 'labId', label: '연구실 ID', type: 'text', placeholder: 'LAB-001' },
      { name: 'productId', label: '화학제품 ID', type: 'text', placeholder: 'CHEM-001' },
      { name: 'quantity', label: '수량', type: 'number', placeholder: '10', coerce: 'number' },
      { name: 'unit', label: '단위', type: 'text', placeholder: 'L' },
      { name: 'location', label: '보관 위치', type: 'text', placeholder: 'A-01' },
    ],
  },
  'chemical-search': {
    title: '시약 재고 조회',
    description: '/api/chemical/search 로 조회합니다.',
    api: '/api/chemical/search',
    mode: 'query',
    fields: [
      { name: 'labId', label: '연구실 ID', type: 'text', placeholder: 'LAB-001' },
      { name: 'productId', label: '화학제품 ID', type: 'text', placeholder: 'CHEM-001' },
    ],
  },
  'chemical-approval': {
    title: '화학물질 반입 승인',
    description: '/api/chemical/search 로 조회합니다.',
    api: '/api/chemical/search',
    mode: 'query',
    fields: [
      { name: 'labId', label: '연구실 ID', type: 'text', placeholder: 'LAB-001' },
      { name: 'productId', label: '화학제품 ID', type: 'text', placeholder: 'CHEM-001' },
    ],
  },
  'waste-register': {
    title: '폐기물 정보 등록',
    description: '/api/waste/register 로 POST를 보냅니다.',
    api: '/api/waste/register',
    mode: 'json',
    fields: [
      { name: 'typeId', label: '폐기물 유형 ID', type: 'text', placeholder: 'W-001' },
      { name: 'labId', label: '연구실 ID', type: 'text', placeholder: 'LAB-001' },
      { name: 'quantity', label: '수량', type: 'number', placeholder: '2.5', coerce: 'number' },
      { name: 'unit', label: '단위', type: 'text', placeholder: 'kg' },
      { name: 'generatedDate', label: '생성일', type: 'date', coerce: 'string' },
    ],
  },
  'waste-search': {
    title: '폐기물 정보 조회',
    description: '/api/waste/search 로 조회합니다.',
    api: '/api/waste/search',
    mode: 'query',
    fields: [
      { name: 'labId', label: '연구실 ID', type: 'text', placeholder: 'LAB-001' },
      { name: 'typeId', label: '폐기물 유형 ID', type: 'text', placeholder: 'W-001' },
    ],
  },
  'waste-request': {
    title: '폐기물 처리 요청',
    description: '/api/waste/search 로 조회합니다.',
    api: '/api/waste/search',
    mode: 'query',
    fields: [
      { name: 'labId', label: '연구실 ID', type: 'text', placeholder: 'LAB-001' },
      { name: 'typeId', label: '폐기물 유형 ID', type: 'text', placeholder: 'W-001' },
    ],
  },
  'daily-register': {
    title: '일상점검 등록',
    description: '/api/lab/inspection 로 JSON을 POST합니다.',
    api: '/api/lab/inspection',
    mode: 'raw-json',
    payload: `{
  "labId": "LAB-01",
  "date": "2026-06-12",
  "submittedBy": "홍길동",
  "status": "OPEN",
  "items": [
    { "checkItem": "소화기", "result": "PASS" },
    { "checkItem": "비상구", "result": "PASS" }
  ]
}`
  },
  'daily-search': {
    title: '일상점검 현황 조회',
    description: '/api/lab/inspection/search 로 조회합니다.',
    api: '/api/lab/inspection/search',
    mode: 'query',
    fields: [
      { name: 'labId', label: '연구실 ID', type: 'text', placeholder: 'LAB-01' },
      { name: 'status', label: '상태', type: 'text', placeholder: 'OPEN' },
    ],
  },
  'daily-defect-action': {
    title: '결함 사항 조치 요구 등록',
    description: '/api/lab/inspection/search 로 조회합니다.',
    api: '/api/lab/inspection/search',
    mode: 'query',
    fields: [
      { name: 'labId', label: '연구실 ID', type: 'text', placeholder: 'LAB-01' },
      { name: 'status', label: '상태', type: 'text', placeholder: 'OPEN' },
    ],
  },
  'education-register': {
    title: '연구활동종사자 분류 등록',
    description: '/api/education/categories 로 POST를 보냅니다.',
    api: '/api/education/categories',
    mode: 'json',
    fields: [
      { name: 'categoryName', label: '분류명', type: 'text', placeholder: '연구원' },
      { name: 'description', label: '설명', type: 'text', placeholder: '안전교육 대상 분류' },
    ],
  },
  'education-search': {
    title: '연구활동종사자 분류 조회',
    description: '/api/education/queries 로 조회합니다.',
    api: '/api/education/queries',
    mode: 'query',
    fields: [
      { name: 'categoryName', label: '분류명', type: 'text', placeholder: '연구원' },
    ],
  },
  'education-warning': {
    title: '미이수자 경고 알림',
    description: '/api/education/queries 로 조회합니다.',
    api: '/api/education/queries',
    mode: 'query',
    fields: [
      { name: 'categoryName', label: '분류명', type: 'text', placeholder: '연구원' },
    ],
  },
};

function escapeHtml(value) {
  return String(value)
    .replaceAll('&', '&amp;')
    .replaceAll('<', '&lt;')
    .replaceAll('>', '&gt;')
    .replaceAll('"', '&quot;');
}

function renderField(field) {
  if (field.type === 'select') {
    const options = field.options.map((option) => `<option value="${escapeHtml(option)}">${escapeHtml(option)}</option>`).join('');
    return `<label><span>${escapeHtml(field.label)}</span><select name="${escapeHtml(field.name)}" ${field.coerce ? `data-coerce="${escapeHtml(field.coerce)}"` : ''}>${options}</select></label>`;
  }

  return `<label><span>${escapeHtml(field.label)}</span><input name="${escapeHtml(field.name)}" type="${escapeHtml(field.type || 'text')}" placeholder="${escapeHtml(field.placeholder || '')}" ${field.coerce ? `data-coerce="${escapeHtml(field.coerce)}"` : ''}></label>`;
}

function localizeKey(key) {
  const translations = {
    id: '번호',
    name: '이름',
    role: '역할',
    message: '메시지',
    stockId: '시약 번호',
    labId: '연구실 ID',
    productId: '화학제품 ID',
    productName: '화학제품명',
    quantity: '수량',
    unit: '단위',
    location: '보관 위치',
    registeredAt: '등록일시',
    date: '날짜',
    status: '상태',
    submittedBy: '등록자',
    items: '점검 항목',
    checkItem: '점검 항목',
    result: '결과',
    labName: '연구실 이름',
    buildingId: '건물 ID',
    floor: '층수',
    type: '유형',
    inspectionTarget: '점검 대상 여부',
    categoryName: '분류명',
    description: '설명',
    typeId: '폐기물 유형 ID',
    generatedDate: '생성일',
  };

  return translations[key] || key;
}

function renderListItem(label, value) {
  if (value === null || value === undefined || value === '') {
    return `<li class="result-item"><strong>${escapeHtml(localizeKey(label))}:</strong> -</li>`;
  }

  if (Array.isArray(value)) {
    const children = value.map((item, index) => renderListItem(String(index + 1), item)).join('');
    return `<li class="result-item"><strong>${escapeHtml(localizeKey(label))}:</strong><ul class="result-list">${children}</ul></li>`;
  }

  if (typeof value === 'object') {
    const entries = Object.entries(value).map(([key, nestedValue]) => renderListItem(key, nestedValue)).join('');
    return `<li class="result-item"><strong>${escapeHtml(localizeKey(label))}:</strong><ul class="result-list">${entries}</ul></li>`;
  }

  return `<li class="result-item"><strong>${escapeHtml(localizeKey(label))}:</strong> ${escapeHtml(value)}</li>`;
}

function renderResult(value) {
  if (value === null || value === undefined) {
    return '<ul class="result-list"><li class="result-item">응답이 비어 있습니다.</li></ul>';
  }

  if (Array.isArray(value)) {
    return `<ul class="result-list">${value.map((item, index) => renderListItem(String(index + 1), item)).join('')}</ul>`;
  }

  if (typeof value === 'object') {
    return `<ul class="result-list">${Object.entries(value).map(([key, nestedValue]) => renderListItem(key, nestedValue)).join('')}</ul>`;
  }

  return `<ul class="result-list"><li class="result-item">${escapeHtml(value)}</li></ul>`;
}

function renderPage(root, config) {
  document.title = config.title;

  const fieldsMarkup = config.fields ? `<div class="grid">${config.fields.map(renderField).join('')}</div>` : '';
  const payloadMarkup = config.mode === 'raw-json'
    ? `<label><span>JSON 본문</span><textarea name="payload" spellcheck="false">${escapeHtml(config.payload || '{}')}</textarea></label>`
    : fieldsMarkup;

  root.innerHTML = `
    <div class="topbar">
      <a class="home-link" href="/">홈</a>
      <span class="pill">${escapeHtml(config.api)}</span>
    </div>
    <section class="hero">
      <h1>${escapeHtml(config.title)}</h1>
      <p>${escapeHtml(config.description)}</p>
    </section>
    <section class="card">
      <form data-api="${escapeHtml(config.api)}" data-mode="${escapeHtml(config.mode)}">
        ${payloadMarkup}
        <div style="margin-top:16px;"><button class="button" type="submit">기능 시험 실행</button></div>
      </form>
    </section>
    <section class="card">
      <div class="status"><span>결과</span><span class="pill" data-status>대기 중</span></div>
      <div data-result><ul class="result-list"><li class="result-item">아직 실행하지 않았습니다.</li></ul></div>
    </section>`;

  const form = root.querySelector('form[data-api]');
  const status = root.querySelector('[data-status]');
  const result = root.querySelector('[data-result]');

  form.addEventListener('submit', async (event) => {
    event.preventDefault();
    status.textContent = '조회 중';

    try {
      let url = form.dataset.api;
      let init = { method: 'GET' };

      if (form.dataset.mode === 'raw-json') {
        const payload = form.querySelector('textarea[name="payload"]').value;
        init = { method: 'POST', headers: { 'Content-Type': 'application/json' }, body: payload };
      } else if (form.dataset.mode === 'query') {
        const params = new URLSearchParams();
        form.querySelectorAll('input[name], select[name]').forEach((field) => {
          const value = field.value.trim();
          if (value !== '') {
            params.set(field.name, value);
          }
        });
        url = params.toString() ? `${url}?${params.toString()}` : url;
      } else {
        const body = {};
        form.querySelectorAll('input[name], select[name]').forEach((field) => {
          if (field.type === 'checkbox') {
            body[field.name] = field.checked;
            return;
          }
          if (field.dataset.coerce === 'number') {
            body[field.name] = field.value === '' ? null : Number(field.value);
            return;
          }
          if (field.dataset.coerce === 'boolean') {
            body[field.name] = field.value === 'true';
            return;
          }
          body[field.name] = field.value.trim();
        });
        init = { method: 'POST', headers: { 'Content-Type': 'application/json' }, body: JSON.stringify(body) };
      }

      const response = await fetch(url, init);
      const text = await response.text();
      let parsed;
      try {
        parsed = JSON.parse(text);
      } catch {
        parsed = text;
      }
      status.textContent = response.ok ? '성공' : '실패';
      result.innerHTML = renderResult(parsed);
    } catch (error) {
      status.textContent = '오류';
      result.innerHTML = `<ul class="result-list"><li class="result-item">${escapeHtml(error instanceof Error ? error.message : String(error))}</li></ul>`;
    }
  });
}

document.addEventListener('DOMContentLoaded', () => {
  const root = document.querySelector('[data-page]');
  if (!root) {
    return;
  }

  const config = PAGE_CONFIGS[root.dataset.page];
  if (!config) {
    root.textContent = `알 수 없는 페이지: ${root.dataset.page}`;
    return;
  }

  renderPage(root, config);
});
