<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="../include/header.jsp" %>

<% String endTime = request.getParameter("endTime"); %>

<div class="resvPost-wrap">
    <div class="resvPost-title">예약 신청서 작성</div>
    <div class="resvPost-left">        
        <h3>이용약관</h3>
        <div class="resvPost-accordion">
            <div class="panel-group resvPost-group" id="accordion">
                <div class="panel panel-default resvPost-panel">
                    <div class="panel-heading resvPost-panel-heading">
                        <h4 class="panel-title resvPost-panel-title">
                            <a data-toggle="collapse" data-parent="#accordion" href="#collapse1">개인정보 처리 방침</a>
                        </h4>
                    </div>
                    <div id="collapse1" class="panel-collapse collapse resvPost-collapse">
                        <div class="panel-body">
                            <div class="resvPost-container">
                                <!-- 개인정보 처리 방침 내용 -->
                            </div>
                            <input type="checkbox" required>동의 합니다.
                        </div>
                    </div>
                </div>
                <div class="panel panel-default resvPost-panel">
                    <div class="panel-heading resvPost-panel-heading">
                        <h4 class="panel-title resvPost-panel-title">
                            <a data-toggle="collapse" data-parent="#accordion" href="#collapse2">예약 안내</a>
                        </h4>
                    </div>
                    <div id="collapse2" class="panel-collapse collapse resvPost-collapse">
                        <div class="panel-body">
                            <!-- 예약 안내 내용 -->
                            <ul>
                                <li><input type="checkbox" required>확인했습니다.</li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <form id="form1" class="resvPost-form" action="submitReservation.reservation" method="post">
            <h3>상세 내용 작성</h3>
            <div class="form-group resvPost-form-group">
                <label for="res-name">장소 신청자</label>
                <input type="text" class="form-control" id="res-name" name="res-name" value="${userName}" readonly>
                <label for="res-content">공연 내용을 작성해 주세요.</label>
                <input type="text" class="form-control" id="res-content" name="res-content" placeholder="상세하게 작성해 주세요." required>
                <label for="res-count">공연 인원</label>
                <input type="text" class="form-control" id="res-count" name="res-count" required>
                <label for="res-amp">설치물</label>
                <input type="text" class="form-control" id="res-amp" name="res-amp">
                <input type="hidden" name="locaId" value="${location.locaId}">
                <input type="hidden" name="resDate" value="${resDate}">
                <input type="hidden" name="resTime" value="${resTime}">
            </div>
        </form>
    </div>
        
    <div class="resvPost-sticky">
        <div class="resvPost-right">
            <h3>예약 확인</h3>
            <div class="resvPost-right-img">
                <img src="${locaPicPath}" alt="${locaName}">
            </div>
            <div class="resvPost-right-content">
                <h4>${userName}님</h4>
                <ul>
                    <li>
                        <b>공연 장소</b>
                        <p>${locaName} (${locaPlace})</p>
                    </li>
                    <li>
                        <b>공연 날짜</b>
                        <p>${resDate}</p>
                    </li>
                    <li>
                        <b>공연 시간</b>
                        <p>${resTime} ~ ${endTime}</p>
                    </li>
                </ul>
            </div>
            <div class="resvPost-control">
                <button type="submit" form="
