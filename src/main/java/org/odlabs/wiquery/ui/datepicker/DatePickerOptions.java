/*
 * Copyright (c) 2009 WiQuery team
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package org.odlabs.wiquery.ui.datepicker;

import java.io.Serializable;

import org.odlabs.wiquery.core.javascript.JsScope;
import org.odlabs.wiquery.core.options.ICollectionItemOptions;
import org.odlabs.wiquery.core.options.IComplexOption;
import org.odlabs.wiquery.core.options.ListItemOptions;
import org.odlabs.wiquery.core.options.LiteralOption;
import org.odlabs.wiquery.core.options.Options;
import org.odlabs.wiquery.ui.core.JsScopeUiEvent;
import org.odlabs.wiquery.ui.datepicker.DatePicker.ShowOnEnum;
import org.odlabs.wiquery.ui.datepicker.DatePickerDuration.DurationEnum;
import org.odlabs.wiquery.ui.datepicker.scope.JsScopeUiDatePickerDateTextEvent;
import org.odlabs.wiquery.ui.datepicker.scope.JsScopeUiDatePickerEvent;
import org.odlabs.wiquery.ui.datepicker.scope.JsScopeUiDatePickerOnChangeEvent;

/**
 * An options class to store date picker info so that both InlineDatePiker and 
 * datePicker can share them.
 * 
 * @author Ernesto Reinaldo Barreiro (reiern70@gmail.com)
 * @since 1.0.2
 */
public class DatePickerOptions implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	// Properties
	private Options options;
	
	/**
	 * Constructor
	 */
	public DatePickerOptions() {
		options = new Options();
	}
	

	/*---- Options section ---*/
	
	/**The jQuery selector for another field that is to be updated with the 
	 * selected date from the datepicker. Use the altFormat setting below to 
	 * change the format of the date within this field. Leave as blank for no 
	 * alternate field.
	 * @param altField
	 * @return instance of the current component
	 */
	public void setAltField(String altField) {
		this.options.putLiteral("altField", altField);
	}
	
	/**
	 * @return the altField option value
	 */
	public String getAltField() {
		String altField = this.options.getLiteral("altField");
		return altField == null ? "" : altField;
	}
	
	/**The dateFormat to be used for the altField option. This allows one date 
	 * format to be shown to the user for selection purposes, while a different 
	 * format is actually sent behind the scenes.
	 * 
	 * The format can be combinations of the following:
	 * <ul>
	 * 	<li>d - day of month (no leading zero)</li>
	 * 	<li>dd - day of month (two digit)</li>
	 * 	<li>o - day of the year (no leading zeros)</li>
	 * 	<li>oo - day of the year (three digit)</li>
	 * 	<li>D - day name short</li>
	 * 	<li>DD - day name long</li>
	 * 	<li>m - month of year (no leading zero)</li>
	 * 	<li>mm - month of year (two digit)</li>
	 * 	<li>M - month name short</li>
	 * 	<li>MM - month name long</li>
	 * 	<li>y - year (two digit)</li>
	 * 	<li>yy - year (four digit)</li>
	 * 	<li>@ - Unix timestamp (ms since 01/01/1970)</li>
	 * 	<li>'...' - literal text</li>
	 * 	<li>'' - single quote</li>
	 * 	<li>anything else - literal text</li>
	 * </ul>
	 * 
	 * @param altFormat
	 * @return instance of the current component
	 */
	public void setAltFormat(String altFormat) {
		this.options.putLiteral("altFormat", altFormat);
	}
	
	/**
	 * @return the altFormat option value
	 */
	public String getAltFormat() {
		String altFormat = this.options.getLiteral("altFormat");
		return altFormat == null ? "" : altFormat;
	}
	
	/**Set's the text to display after each date field, e.g. to show the required format.
	 * @param appendText
	 * @return instance of the current component
	 */
	public void setAppendText(String appendText) {
		this.options.putLiteral("appendText", appendText);
	}
	
	/**
	 * @return the appendText option value
	 */
	public String getAppendText() {
		String appendText = this.options.getLiteral("appendText");
		return appendText == null ? "" : appendText;
	}
	
	/**
	 * Set to true to automatically resize the input field to accomodate dates 
	 * in the current dateFormat.
	 * @return instance of the current component
	 */
	public void setAutoSize(boolean autoSize) {
		options.put("autoSize", autoSize);
	}

	/**
	 * @return the autoSize option
	 */
	public boolean isAutoSize() {
		if(this.options.containsKey("autoSize")){
			return options.getBoolean("autoSize");
		}
		
		return false;
	}
	
	/**Set's URL for the popup button image. If set, button text becomes the alt 
	 * value and is not directly displayed.
	 * @param buttonImage
	 * @return instance of the current component
	 */
	public void setButtonImage(String buttonImage) {
		this.options.putLiteral("buttonImage", buttonImage);
	}
	
	/**
	 * @return the buttonImage option value
	 */
	public String getButtonImage() {
		String buttonImage = this.options.getLiteral("buttonImage");
		return buttonImage == null ? "" : buttonImage;
	}
	
	/**Set to true to place an image after the field to use as the trigger 
	 * without it appearing on a button.
	 * @param buttonImageOnly
	 * @return instance of the current component
	 */
	public void setButtonImageOnly(boolean buttonImageOnly) {
		options.put("buttonImageOnly", buttonImageOnly);
	}

	/**
	 * @return the buttonImageOnly option value
	 */
	public boolean isButtonImageOnly() {
		if(this.options.containsKey("buttonImageOnly")){
			return options.getBoolean("buttonImageOnly");
		}
		
		return false;
	}
	
	/**Set's the text to display on the trigger button. Use in conjunction with 
	 * showOn equal to 'button' or 'both'.
	 * @param buttonText
	 * @return instance of the current component
	 */
	public void setButtonText(String buttonText) {
		this.options.putLiteral("buttonText", buttonText);
	}
	
	/**
	 * @return the buttonText option value
	 */
	public String getButtonText() {
		String buttonText = this.options.getLiteral("buttonText");
		return buttonText == null ? "..." : buttonText;
	}
	
	/**A function to calculate the week of the year for a given date. The default 
	 * implementation uses the ISO 8601 definition: weeks start on a Monday; 
	 * the first week of the year contains the first Thursday of the year.
	 * 
	 * Default: $.datepicker.iso8601Week
	 * 
	 * @param calculateWeek
	 * @return instance of the current component
	 */
	public void setCalculateWeek(JsScope calculateWeek) {
		this.options.put("calculateWeek", calculateWeek);
	}

	/**
	 * Sets if the date's month is selectable in a drop down list or not.
	 * @return instance of the current component
	 */
	public void setChangeMonth(boolean changeMonth) {
		options.put("changeMonth", changeMonth);
	}

	/**
	 * Returns true if the date's month is selectable in a drop down list,
	 * returns false otherwise.
	 */
	public boolean isChangeMonth() {
		if(this.options.containsKey("changeMonth")){
			return options.getBoolean("changeMonth");
		}
		
		return false;
	}
	
	/**The text to display for the week of the year column heading. This attribute 
	 * is one of the regionalisation attributes. Use showWeek to display this column.
	 * @param weekHeader
	 * @return instance of the current component
	 */
	public void setWeekHeader(String weekHeader) {
		this.options.putLiteral("weekHeader", weekHeader);
	}
	
	/**
	 * @return the weekHeader option value
	 */
	public String getWeekHeader() {
		String weekHeader = this.options.getLiteral("weekHeader");
		return weekHeader == null ? "WK" : weekHeader;
	}

	/**
	 * Sets the selectable year range. This range can either be defined by a
	 * start year and an end year (like 2001 to 2010), or it can be defined
	 * relatively to the today's date (like current-10 to current+10).
	 * 
	 * @param yearRange
	 * @return instance of the current component
	 */
	public void setYearRange(DatePickerYearRange yearRange) {
		options.put("yearRange", yearRange);
	}
	
	/**
	 * @return the year range valu option
	 */
	public DatePickerYearRange getYearRange() {
		IComplexOption yearRange = this.options.getComplexOption("yearRange");
		if(yearRange != null && yearRange instanceof DatePickerYearRange){
			return (DatePickerYearRange)yearRange;
		}
		
		return null;
	}
	
	/**Additional text to display after the year in the month headers. This 
	 * attribute is one of the regionalisation attributes.
	 * @param yearSuffix
	 * @return instance of the current component
	 */
	public void setYearSuffix(String yearSuffix) {
		this.options.putLiteral("yearSuffix", yearSuffix);
	}
	
	/**
	 * @return the yearSuffix option value
	 */
	public String getYearSuffix() {
		String yearSuffix = this.options.getLiteral("yearSuffix");
		return yearSuffix == null ? "" : yearSuffix;
	}

	/**
	 * Sets if the date's year is selectable in a drop down list or not.
	 * @return instance of the current component
	 */
	public void setChangeYear(boolean changeYear) {
		options.put("changeYear", changeYear);
	}

	/**
	 * Returns true if the date's year is selectable in a drop down list,
	 * returns false otherwise.
	 */
	public boolean isChangeYear() {
		if(this.options.containsKey("changeYear")){
			return options.getBoolean("changeYear");
		}
		
		return false;
	}
	
	/**Set's the text to display for the close link. This attribute is one of 
	 * the regionalisation attributes. Use the showButtonPanel to display this button.
	 * @param closeText
	 * @return instance of the current component
	 */
	public void setCloseText(String closeText) {
		this.options.putLiteral("closeText", closeText);
	}
	
	/**
	 * @return the closeText option value
	 */
	public String getCloseText() {
		String closeText = this.options.getLiteral("closeText");
		return closeText == null ? "Done" : closeText;
	}
	
	/**True if the input field is constrained to the current date format.
	 * @param constrainInput
	 * @return instance of the current component
	 */
	public void setConstrainInput(boolean constrainInput) {
		options.put("constrainInput", constrainInput);
	}

	/**
	 * @return the buttonImageOnly option value
	 */
	public boolean isConstrainInput() {
		if(this.options.containsKey("constrainInput")){
			return options.getBoolean("constrainInput");
		}
		
		return true;
	}
	
	/**Set's the text to display for the current day link. This attribute is one 
	 * of the regionalisation attributes. Use the showButtonPanel to display 
	 * this button.
	 * @param currentText
	 * @return instance of the current component
	 */
	public void setCurrentText(String currentText) {
		this.options.putLiteral("currentText", currentText);
	}
	
	/**
	 * @return the currentText option value
	 */
	public String getCurrentText() {
		String currentText = this.options.getLiteral("currentText");
		return currentText == null ? "Today" : currentText;
	}

	/**
	 * Sets the calendar's starting day. 0 is for sunday, 1 for monday ...
	 * 
	 * @param firstDay
	 * @return instance of the current component
	 */
	public void setFirstDay(short firstDay) {
		options.put("firstDay", firstDay);
	}

	/**
	 * Returns the calendar's starting day.
	 */
	public short getFirstDay() {
		if(this.options.containsKey("firstDay")){
			return options.getShort("firstDay");
		}
		
		return 0;
	}
	
	/**If true, the current day link moves to the currently selected date instead of today.
	 * @param gotoCurrent
	 * @return instance of the current component
	 */
	public void setGotoCurrent(boolean gotoCurrent) {
		options.put("gotoCurrent", gotoCurrent);
	}

	/**
	 * @return the gotoCurrent option value
	 */
	public boolean isGotoCurrent() {
		if(this.options.containsKey("gotoCurrent")){
			return options.getBoolean("gotoCurrent");
		}
		
		return false;
	}
	
	/**Normally the previous and next links are disabled when not applicable 
	 * (see minDate/maxDate). You can hide them altogether by setting this 
	 * attribute to true.
	 * @param hideIfNoPrevNext
	 * @return instance of the current component
	 */
	public void setHideIfNoPrevNext(boolean hideIfNoPrevNext) {
		options.put("hideIfNoPrevNext", hideIfNoPrevNext);
	}

	/**
	 * @return the hideIfNoPrevNext option value
	 */
	public boolean isHideIfNoPrevNext() {
		if(this.options.containsKey("hideIfNoPrevNext")){
			return options.getBoolean("hideIfNoPrevNext");
		}
		
		return false;
	}
	
	/**True if the current language is drawn from right to left. This attribute 
	 * is one of the regionalisation attributes.
	 * @param isRTL
	 * @return instance of the current component
	 */
	public void setIsRTL(boolean isRTL) {
		options.put("isRTL", isRTL);
	}

	/**
	 * @return the isRTL option value
	 */
	public boolean isIsRTL() {
		if(this.options.containsKey("isRTL")){
			return options.getBoolean("isRTL");
		}
		
		return false;
	}
	
	/**Set a maximum selectable date via a Date object, or a number of days from 
	 * today (e.g. +7) or a string of values and periods ('y' for years, 'm' for 
	 * months, 'w' for weeks, 'd' for days, e.g. '+1m +1w'), or null for no limit.
	 * @param maxDate
	 * @return instance of the current component
	 */
	public void setMaxDate(DateOption maxDate) {
		options.put("maxDate", maxDate);
	}

	/**
	 * @return the maxDate option value
	 */
	public DateOption getMaxDate() {
		IComplexOption maxDate = options.getListItemOptions("maxDate");
		
		if(maxDate != null && maxDate instanceof DateOption){
			return (DateOption) maxDate;
		}
		
		return null;
	}
	
	/**Set a minimum selectable date via a Date object, or a number of days from 
	 * today (e.g. +7) or a string of values and periods ('y' for years, 'm' for 
	 * months, 'w' for weeks, 'd' for days, e.g. '+1m +1w'), or null for no limit.
	 * @param minDate
	 * @return instance of the current component
	 */
	public void setMinDate(DateOption minDate) {
		options.put("minDate", minDate);
	}

	/**
	 * @return the minDate option value
	 */
	public DateOption getMinDate() {
		IComplexOption minDate = options.getListItemOptions("minDate");
		
		if(minDate != null && minDate instanceof DateOption){
			return (DateOption) minDate;
		}
		
		return null;
	}
	
	/**Set's the list of full month names, as used in the month header on each 
	 * datepicker and as requested via the dateFormat setting. This attribute is 
	 * one of the regionalisation attributes.
	 * @param monthNames
	 * @return instance of the current component
	 */
	public void setMonthNames(ArrayOfMonthNames monthNames) {
		options.put("monthNames", monthNames);
	}

	/**
	 * @return the monthNames option value
	 */
	public ArrayOfMonthNames getMonthNames() {
		IComplexOption monthNames = options.getComplexOption("monthNames");
		
		if(monthNames != null && monthNames instanceof ArrayOfMonthNames){
			return (ArrayOfMonthNames) monthNames;
		}
		
		return new ArrayOfMonthNames("January", "February", "March", "April", 
				"May", "June", "July", "August", "September", "October", "November", "December");
	}
	
	/**Set's the list of abbreviated month names, for use as requested via the 
	 * dateFormat setting. This attribute is one of the regionalisation attributes.
	 * @param monthNamesShort
	 * @return instance of the current component
	 */
	public void setMonthNamesShort(ArrayOfMonthNames monthNamesShort) {
		options.put("monthNamesShort", monthNamesShort);
	}

	/**
	 * @return the monthNames option value
	 */
	public ArrayOfMonthNames getMonthNamesShort() {
		IComplexOption monthNamesShort = options.getComplexOption("monthNamesShort");
		
		if(monthNamesShort != null && monthNamesShort instanceof ArrayOfMonthNames){
			return (ArrayOfMonthNames) monthNamesShort;
		}
		
		return new ArrayOfMonthNames("Jan", "Feb", "Mar", "Apr", 
				"May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec");
	}
	
	/**When true the formatDate function is applied to the prevText, nextText, 
	 * and currentText values before display, allowing them to display the 
	 * target month names for example.
	 * @param navigationAsDateFormat
	 * @return instance of the current component
	 */
	public void setNavigationAsDateFormat(boolean navigationAsDateFormat) {
		options.put("navigationAsDateFormat", navigationAsDateFormat);
	}

	/**
	 * @return the navigationAsDateFormat option value
	 */
	public boolean isNavigationAsDateFormat() {
		if(this.options.containsKey("navigationAsDateFormat")){
			return options.getBoolean("navigationAsDateFormat");
		}
		
		return false;
	}
	
	/**Set's the text to display for the next month link. This attribute is one 
	 * of the regionalisation attributes. With the standard ThemeRoller styling, 
	 * this value is replaced by an icon.
	 * @param nextText
	 * @return instance of the current component
	 */
	public void setNextText(String nextText) {
		this.options.putLiteral("nextText", nextText);
	}
	
	/**
	 * @return the nextText option value
	 */
	public String getNextText() {
		String nextText = this.options.getLiteral("nextText");
		return nextText == null ? "Next" : nextText;
	}

	/**
	 * Sets if the next/previous months are showed in the calendar.
	 * @return instance of the current component
	 */
	public void setShowOtherMonths(boolean showOtherMonths) {
		options.put("showOtherMonths", showOtherMonths);
	}

	/**
	 * @deprecated will be removed in 1.2
	 * Returns if the next/previous months are showed in the calendar.
	 */
	public boolean getShowOtherMonths() {
		return options.getBoolean("showOtherMonths");
	}
	
	/**
	 * Returns if the next/previous months are showed in the calendar.
	 */
	public boolean isShowOtherMonths() {
		if(this.options.containsKey("showOtherMonths")){
			return options.getBoolean("showOtherMonths");
		}
		
		return false;
	}

	/**
	 * Sets the number of months displayed on the date picker.
	 * @return instance of the current component
	 */
	public void setNumberOfMonths(DatePickerNumberOfMonths numberOfMonths) {
		options.put("numberOfMonths", numberOfMonths);
	}

	/**
	 * Returns the number of months displayed on the date picker.
	 */
	public DatePickerNumberOfMonths getNumberOfMonths() {
		IComplexOption numberOfMonths = options.getComplexOption("numberOfMonths");
		
		if(numberOfMonths != null && numberOfMonths instanceof DatePickerNumberOfMonths){
			return (DatePickerNumberOfMonths) numberOfMonths;
		}
		
		return new DatePickerNumberOfMonths(new Short("1"));
	}
	
	/**Set's the text to display for the previous month link. This attribute is one 
	 * of the regionalisation attributes. With the standard ThemeRoller styling, 
	 * this value is replaced by an icon.
	 * @param prevText
	 * @return instance of the current component
	 */
	public void setPrevText(String prevText) {
		this.options.putLiteral("prevText", prevText);
	}
	
	/**
	 * @return the prevText option value
	 */
	public String getPrevText() {
		String prevText = this.options.getLiteral("prevText");
		return prevText == null ? "Prev" : prevText;
	}
	
	/**When true days in other months shown before or after the current month 
	 * are selectable. This only applies if showOtherMonths is also true.
	 * @param selectOtherMonths
	 * @return instance of the current behavior
	 */
	public void setSelectOtherMonths(boolean selectOtherMonths) {
		this.options.put("selectOtherMonths", selectOtherMonths);
	}
	
	/**
	 * @return the selectOtherMonths option
	 */
	public boolean isSelectOtherMonths() {
		if(this.options.containsKey("selectOtherMonths")){
			return this.options.getBoolean("selectOtherMonths");
		}
		
		return false;
	}
	
	/**Set the cutoff year for determining the century for a date
	 * @param shortYearCutoff
	 * @return instance of the current component
	 */
	public void setShortYearCutoff(DatePickerShortYearCutOff shortYearCutoff) {
		options.put("shortYearCutoff", shortYearCutoff);
	}

	/**
	 * Returns the shortYearCutoff option value.
	 */
	public DatePickerShortYearCutOff getShortYearCutoff() {
		IComplexOption shortYearCutoff = options.getComplexOption("shortYearCutoff");
		
		if(shortYearCutoff != null && shortYearCutoff instanceof DatePickerShortYearCutOff){
			return (DatePickerShortYearCutOff) shortYearCutoff;
		}
		
		return new DatePickerShortYearCutOff("+10");
	}
	
	/**Set the name of the animation used to show/hide the datepicker. Use 
	 * 'show' (the default), 'slideDown', 'fadeIn', or any of the show/hide 
	 * jQuery UI effects
	 * @param showAnim
	 * @return instance of the current component
	 */
	public void setShowAnim(String showAnim) {
		this.options.putLiteral("showAnim", showAnim);
	}
	
	/**
	 * @return the showAnim option value
	 */
	public String getShowAnim() {
		String showAnim = this.options.getLiteral("showAnim");
		return showAnim == null ? "show" : showAnim;
	}
	
	/**Whether to show the button panel.
	 * @param showButtonPanel
	 * @return instance of the current component
	 */
	public void setShowButtonPanel(boolean showButtonPanel) {
		options.put("showButtonPanel", showButtonPanel);
	}

	/**
	 * @return the showButtonPanel option value
	 */
	public boolean isShowButtonPanel() {
		if(this.options.containsKey("showButtonPanel")){
			return options.getBoolean("showButtonPanel");
		}
		
		return false;
	}
	
	/**Specify where in a multi-month display the current month shows, starting 
	 * from 0 at the top/left.
	 * @param showCurrentAtPos
	 * @return instance of the current component
	 */
	public void setShowCurrentAtPos(short showCurrentAtPos) {
		options.put("showCurrentAtPos", showCurrentAtPos);
	}

	/**
	 * @return the showCurrentAtPos option value
	 */
	public short getShowCurrentAtPos() {
		if(this.options.containsKey("showCurrentAtPos")){
			return options.getShort("showCurrentAtPos");
		}
		
		return 0;
	}
	
	/**Whether to show the month after the year in the header.
	 * @param showMonthAfterYear
	 * @return instance of the current component
	 */
	public void setShowMonthAfterYear(boolean showMonthAfterYear) {
		options.put("showMonthAfterYear", showMonthAfterYear);
	}

	/**
	 * @return the showMonthAfterYear option value
	 */
	public boolean isShowMonthAfterYear() {
		if(this.options.containsKey("showMonthAfterYear")){
			return options.getBoolean("showMonthAfterYear");
		}
		
		return false;
	}
	
	/**Have the datepicker appear automatically when the field receives focus 
	 * ('focus'), appear only when a button is clicked ('button'), or appear 
	 * when either event takes place ('both').
	 * @param showOn
	 * @return instance of the current component
	 */
	public void setShowOn(ShowOnEnum showOn) {
		options.putLiteral("showOn", showOn.name().toLowerCase());
	}

	/**
	 * @return the showOn option value
	 */
	public ShowOnEnum getShowOn() {
		String literal = options.getLiteral("showOn");
		return literal == null ? ShowOnEnum.FOCUS : ShowOnEnum.valueOf(literal.toUpperCase());
	}
	
	/**If using one of the jQuery UI effects for showAnim, you can provide 
	 * additional settings for that animation via this option.
	 * @param showOptions
	 * @return instance of the current component
	 */
	public void setShowOptions(ListItemOptions<LiteralOption> showOptions) {
		options.put("showOptions", showOptions);
	}

	/**
	 * @return the showOptions option value
	 */
	@SuppressWarnings("unchecked")
	public ListItemOptions<LiteralOption> getShowOptions() {
		ICollectionItemOptions showOptions = options.getListItemOptions("showOptions");
		
		if(showOptions != null && showOptions instanceof ListItemOptions){
			return (ListItemOptions<LiteralOption>) showOptions;
		}
		
		return null;
	}
	
	/**
	 * When true a column is added to show the week of the year. The calculateWeek 
	 * option determines how the week of the year is calculated. You may also 
	 * want to change the firstDay option.
	 * @return instance of the current component
	 */
	public void setShowWeek(boolean showWeek) {
		options.put("showWeek", showWeek);
	}

	/**
	 * @return the showWeek option
	 */
	public boolean isShowWeek() {
		if(this.options.containsKey("showWeek")){
			return options.getBoolean("showWeek");
		}
		
		return false;
	}

	/**
	 * Sets the number of months stepped when the next/previous button are hit.
	 * @return instance of the current component
	 */
	public void setStepMonths(short stepMonths) {
		options.put("stepMonths", stepMonths);
	}

	/**
	 * Returns the number of months stepped when the next/previous button are
	 * hit.
	 */
	public short getStepMonths() {
		if(this.options.containsKey("stepMonths")){
			return options.getShort("stepMonths");
		}
		
		return 1;
	}

	/**
	 * Sets the ISO date format to use.
	 * 
	 *  The format can be combinations of the following:
	 * <ul>
	 * 	<li>d - day of month (no leading zero)</li>
	 * 	<li>dd - day of month (two digit)</li>
	 * 	<li>o - day of the year (no leading zeros)</li>
	 * 	<li>oo - day of the year (three digit)</li>
	 * 	<li>D - day name short</li>
	 * 	<li>DD - day name long</li>
	 * 	<li>m - month of year (no leading zero)</li>
	 * 	<li>mm - month of year (two digit)</li>
	 * 	<li>M - month name short</li>
	 * 	<li>MM - month name long</li>
	 * 	<li>y - year (two digit)</li>
	 * 	<li>yy - year (four digit)</li>
	 * 	<li>@ - Unix timestamp (ms since 01/01/1970)</li>
	 * 	<li>'...' - literal text</li>
	 * 	<li>'' - single quote</li>
	 * 	<li>anything else - literal text</li>
	 * </ul>
	 * @return instance of the current component
	 */
	public void setDateFormat(String dateFormat) {
		options.putLiteral("dateFormat", dateFormat);
	}

	/**
	 * Returns the ISO date format to use.
	 */
	public String getDateFormat() {
		String dateFormat = options.getLiteral("dateFormat");
		return dateFormat == null ? "mm/dd/yy" : dateFormat;
	}
	
	/**Set's the list of long day names, starting from Sunday, for use as 
	 * requested via the dateFormat setting. They also appear as popup hints 
	 * when hovering over the corresponding column headings. This attribute is 
	 * one of the regionalisation attributes.
	 * @param dayNames
	 * @return instance of the current component
	 */
	public void setDayNames(ArrayOfDayNames dayNames) {
		options.put("dayNames", dayNames);
	}

	/**
	 * @return the dayNames option value
	 */
	public ArrayOfDayNames getDayNames() {
		IComplexOption dayNames = options.getComplexOption("dayNames");
		
		if(dayNames != null && dayNames instanceof ArrayOfDayNames){
			return (ArrayOfDayNames) dayNames;
		}
		
		return new ArrayOfDayNames("Sunday", "Monday", "Tuesday", "Wednesday", 
				"Thursday", "Friday", "Saturday");
	}
	
	/**Set's the list of minimised day names, starting from Sunday, for use as 
	 * column headers within the datepicker. This attribute is one of the 
	 * regionalisation attributes.
	 * @param dayNamesMin
	 * @return instance of the current component
	 */
	public void setDayNamesMin(ArrayOfDayNames dayNamesMin) {
		options.put("dayNamesMin", dayNamesMin);
	}

	/**
	 * @return the dayNamesMin option value
	 */
	public ArrayOfDayNames getDayNamesMin() {
		IComplexOption dayNamesMin = options.getComplexOption("dayNamesMin");
		
		if(dayNamesMin != null && dayNamesMin instanceof ArrayOfDayNames){
			return (ArrayOfDayNames) dayNamesMin;
		}
		
		return new ArrayOfDayNames("Su", "Mo", "Tu", "We", "Th", "Fr", "Sa");
	}
	
	/**Set's the list of abbreviated day names, starting from Sunday, for use as 
	 * requested via the dateFormat setting. This attribute is one of the 
	 * regionalisation attributes.
	 * @param dayNamesShort
	 * @return instance of the current component
	 */
	public void setDayNamesShort(ArrayOfDayNames dayNamesShort) {
		options.put("dayNamesShort", dayNamesShort);
	}

	/**
	 * @return the dayNamesShort option value
	 */
	public ArrayOfDayNames getDayNamesShort() {
		IComplexOption dayNamesShort = options.getComplexOption("dayNamesShort");
		
		if(dayNamesShort != null && dayNamesShort instanceof ArrayOfDayNames){
			return (ArrayOfDayNames) dayNamesShort;
		}
		
		return new ArrayOfDayNames("Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat");
	}
	
	/**Set the date to highlight on first opening if the field is blank. Specify 
	 * either an actual date via a Date object, or a number of days from today 
	 * (e.g. +7) or a string of values and periods ('y' for years, 'm' for months, 
	 * 'w' for weeks, 'd' for days, e.g. '+1m +7d'), or null for today.
	 * @param defaultDate
	 * @return instance of the current component
	 */
	public void setDefaultDate(DateOption defaultDate) {
		options.put("defaultDate", defaultDate);
	}

	/**
	 * @return the defaultDate option value
	 */
	public DateOption getDefaultDate() {
		IComplexOption defaultDate = options.getComplexOption("defaultDate");
		
		if(defaultDate != null && defaultDate instanceof DateOption){
			return (DateOption) defaultDate;
		}
		
		return null;
	}
	
	/**Disables (true) or enables (false) the datepicker. Can be set when 
	 * initialising (first creating) the datepicker.
	 * @param disabled
	 * @return instance of the current behavior
	 */
	public void setDisabled(boolean disabled) {
		this.options.put("disabled", disabled);
	}
	
	/**
	 * @return the disabled option
	 */
	public boolean isDisabled() {
		if(this.options.containsKey("disabled")){
			return this.options.getBoolean("disabled");
		}
		
		return false;
	}
	
	/**Control the speed at which the datepicker appears, it may be a time in 
	 * milliseconds, a string representing one of the three predefined speeds 
	 * ("slow", "normal", "fast"), or '' for immediately.
	 * @param duration
	 * @return instance of the current component
	 */
	public void setDuration(DatePickerDuration duration) {
		options.put("duration", duration);
	}

	/**
	 * @return the duration option value
	 */
	public DatePickerDuration getDuration() {
		IComplexOption duration = options.getComplexOption("duration");
		
		if(duration != null && duration instanceof DatePickerDuration){
			return (DatePickerDuration) duration;
		}
		
		return new DatePickerDuration(DurationEnum.NORMAL);
	}

	/*---- Events section ---*/
	
	/**Set's the callback before the datepicker is displayed.
	 * @param beforeShow
	 * @return instance of the current component
	 */
	public void setBeforeShowEvent(JsScopeUiEvent beforeShow) {
		this.options.put("beforeShow", beforeShow);
	}
	
	/**The function takes a date as a parameter and must return an array with [0] 
	 * equal to true/false indicating whether or not this date is selectable, [1] 
	 * equal to a CSS class name(s) or '' for the default presentation and [2] 
	 * an optional popup tooltip for this date. It is called for each day in 
	 * the datepicker before is it displayed.
	 * @param beforeShowDay
	 * @return instance of the current component
	 */
	public void setBeforeShowDayEvent(JsScopeUiDatePickerEvent beforeShowDay) {
		this.options.put("beforeShowDay", beforeShowDay);
	}
	
	/**Allows you to define your own event when the datepicker moves to a new 
	 * month and/or year. The function receives the selected year, month (1-12), 
	 * and the datepicker instance as parameters. this refers to the associated 
	 * input field.
	 * @param onChangeMonthYear
	 * @return instance of the current component
	 */
	public void setOnChangeMonthYearEvent(JsScopeUiDatePickerOnChangeEvent onChangeMonthYear) {
		this.options.put("onChangeMonthYear", onChangeMonthYear);
	}
	
	/**Allows you to define your own event when the datepicker is closed, whether 
	 * or not a date is selected. The function receives the selected date as text 
	 * and the datepicker instance as parameters. this refers to the associated 
	 * input field.
	 * @param onClose
	 * @return instance of the current component
	 */
	public void setOnCloseEvent(JsScopeUiDatePickerDateTextEvent onClose) {
		this.options.put("onClose", onClose);		
	}
	
	/**Allows you to define your own event when the datepicker is selected. The 
	 * function receives the selected date as text and the datepicker instance 
	 * as parameters. this refers to the associated input field.
	 * @param onSelect
	 * @return instance of the current component
	 */
	public void setOnSelectEvent(JsScopeUiDatePickerDateTextEvent onSelect) {
		this.options.put("onSelect", onSelect);		
	}


	public Options getOptions() {
		return options;
	}
}