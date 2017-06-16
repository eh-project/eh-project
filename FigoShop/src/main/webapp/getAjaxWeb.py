# -*- coding: utf-8 -*-
import sys
import urllib
import time
def getData (url):
    if url != "":
        from selenium import webdriver
        driver = webdriver.PhantomJS(service_args=['--ignore-ssl-errors=true'])
        driver.get(url)

        time.sleep(3)

        domStr=driver.execute_script("return document.documentElement.outerHTML")
        sourcex=domStr.encode('utf-8')
        driver.quit
        sys.exit
        return sourcex
    else :
        return ""

data = getData(sys.argv[1])
print data
