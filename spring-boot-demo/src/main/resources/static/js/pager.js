/**
 * 分页组件，依赖boostrap.css样式表，通过传入JSON对象实现分页。支持自定义分页大小，分页按钮数量。
 * 用法：1. pager.init(currentPage, pageSize, pageButton);
 *      2. pager.setLayout(selectorId, jsonData, totalSize, callback);
 *      3. pager.start() 当前页开始记录，pager.end() 当前页结束记录.
 * @author ljun51@outlook.com
 * @date   2016-04-15
 */
var pager = (function(document) {
    // 每页显示多少条记录，默认为10条
    var _pageSize = 10;
    // 显示多数个有效的分页按钮，默认为6个
    var _pageButton = 6;
    // 当前页
    var _currentPage = 1;
    // 总页数
    var _totalPage = 0;
    // 总记录数
    var _totalSize = 0;
    // 当前页开始记录
    var _startNum = _pageSize * (parseInt(_currentPage) - 1) + 1;
    // 当前页结束记录
    var _endNum = _currentPage * _pageSize;
    var _callback;
    var _pagerDiv;
    var _jsonData;

    /**
     * 分页初始化方法
     * @param currentPage 当前页
     * @param pageSize    每页记录数量
     * @param pageButton  每页按钮数量，按钮数量必须>=6
     */
    var init = function(currentPage, pageSize, pageButton) {
        _currentPage = currentPage || 1;
        _pageSize = pageSize || 10;
        _pageButton = pageButton || 6;
        if (_pageButton < 6) {
            _pageButton = 6;
        }
        _startNum = _pageSize * (parseInt(_currentPage) - 1) + 1;
        _endNum = _currentPage * _pageSize;
        _jsonData = null;
    };

    var setPagerButton = function(text, value) {
        var a = document.createElement('a');
        a.innerHTML = text;
        a.href = 'javascript:pager.doPage(\'' + value + '\')';

        var li = document.createElement('li');
        li.appendChild(a);
        return li;
    };

    var setPagerText = function() {
        var textDiv = document.createElement('div');
        textDiv.style.display = 'inline';
        textDiv.style.float = 'left';
        textDiv.style.color = 'grey';
        textDiv.innerHTML = '第 ' + _startNum + ' - ' + _currentPage * _pageSize + ' 条 共 ' + _totalSize + ' 条';
        return textDiv;
    }

    /**
     * 设置分页布局
     * @param selectorId 分页容器ID
     * @param jsonData   JSON对象
     * @param totalSize  总记录数
     * @param callback   回调布局函数
     */
    var setLayout = function(selectorId, jsonData, totalSize, callback) {
        var selector = document.getElementById(selectorId);
        if (!selector) {
            console.error('Pager element\'s ID must be given.');
            return;
        }
        selector.innerHTML = '';
        if (!jsonData) {
            console.error('jsonData is null or undefined');
            return;
        }
        _jsonData = jsonData;
        _totalSize = totalSize;
        _callback = callback;
        _pagerDiv = selectorId;

        _totalPage = Math.ceil(_totalSize / _pageSize);

        var pagerDiv = document.createElement('div');
        pagerDiv.className = 'pagination pagination-right';
        selector.appendChild(pagerDiv);

        var textDiv = setPagerText();
        pagerDiv.appendChild(textDiv);

        var ul = document.createElement('ul');
        pagerDiv.appendChild(ul);

        var lastButton = setPagerButton('Prev', 'prev');
        ul.appendChild(lastButton);

        if (_totalPage <= _pageButton) {
            for (var i = 1; i <= _totalPage; i++) {
                var button = setPagerButton(i, i);
                if (i === _currentPage) {
                    button.className = 'active';
                }
                ul.appendChild(button);
            }
        } else if (_currentPage <= _totalPage - Math.floor(_pageButton / 2)) {
            if (_currentPage <= Math.floor(_pageButton / 2) + 1) {
                for (var i = 1; i <= Math.floor(_pageButton / 2) + 2; i++) {
                    var button = setPagerButton(i, i);
                    if (i === _currentPage) {
                        button.className = 'active';
                    }
                    ul.appendChild(button);
                }

                var dotButton = setPagerButton('...', 0);
                dotButton.childNodes.item(0).href = 'javascript:void(0)';
                ul.appendChild(dotButton);

                var totalButton = setPagerButton(_totalPage, _totalPage);
                ul.appendChild(totalButton);
            } else {
                var firstButton = setPagerButton(1, 1);
                ul.appendChild(firstButton);
                var dot1Button = setPagerButton('...', 0);
                dot1Button.childNodes.item(0).href = 'javascript:void(0)';
                ul.appendChild(dot1Button);
                for (var i = _currentPage - Math.floor(_pageButton / 2) + 2; i <= _currentPage + Math.floor(_pageButton / 2) - 2; i++) {
                    var button = setPagerButton(i, i);
                    if (i === _currentPage) {
                        button.className = 'active';
                    }
                    ul.appendChild(button);
                }

                var dot2Button = setPagerButton('...', 0);
                dot2Button.childNodes.item(0).href = 'javascript:void(0)';
                ul.appendChild(dot2Button);

                var totalButton = setPagerButton(_totalPage, _totalPage);
                ul.appendChild(totalButton);
            }
        } else if (_currentPage > _totalPage - Math.floor(_pageButton / 2)) {
            var firstButton = setPagerButton(1, 1);
            ul.appendChild(firstButton);
            var dotButton = setPagerButton('...', 0);
            dotButton.childNodes.item(0).href = 'javascript:void(0)';
            ul.appendChild(dotButton);
            for (var i = _totalPage - Math.floor(_pageButton / 2); i <= _totalPage; i++) {
                var button = setPagerButton(i, i);
                if (i == _currentPage) {
                    button.className = 'active';
                }
                ul.appendChild(button);
            }
        }

        var nextButton = setPagerButton('Next', 'next');
        ul.appendChild(nextButton);

        if (_currentPage === 1 || _totalSize === 0) {
            lastButton.className = 'disabled';
            lastButton.childNodes.item(0).href = 'javascript:void(0)';
        }
        if (_currentPage == _totalPage || _totalSize == 0) {
            nextButton.className = 'disabled';
            nextButton.childNodes.item(0).href = 'javascript:void(0)';
        }
        callback();
    };

    var doPage = function(value) {
        if (value === 'prev') {
            _currentPage -= 1;
        } else if (value === 'next') {
            _currentPage += 1;
        } else {
            _currentPage = parseInt(value);
        }

        _startNum = _pageSize * (parseInt(_currentPage) - 1) + 1;
        _endNum = _currentPage * _pageSize;
        if (_currentPage <= _totalPage) {
            this.setLayout(_pagerDiv, _jsonData, _totalSize, _callback);
        }
    };

    return {
        start: function() {
            return _startNum;
        },
        end: function() {
            return _endNum;
        },
        currentPage: function() {
            return _currentPage;
        },
        init: init,
        setLayout: setLayout,
        doPage: doPage
    };
})(document);
