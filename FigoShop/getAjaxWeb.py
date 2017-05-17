# -*- coding: utf-8 -*-
import sys
import urllib  
def getData (url):
    if url != "":
        from selenium import webdriver
        driver = webdriver.PhantomJS()
        driver.get(url)
        sourcex = driver.page_source.encode('utf-8')
        driver.quit
        sys.exit
        return sourcex
    else :
        return ""

data = getData(sys.argv[1])
print data
