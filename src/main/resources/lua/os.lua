--
-- Created by IntelliJ IDEA.
-- User: vestein
-- Date: 26.01.2016
-- Time: 02.32
-- To change this template use File | Settings | File Templates.
--

os = {}

function os.pullEvent()
    local returnValue = {}
    while returnValue['id'] == nil do
        returnValue = jos.eventBus(returnValue)
        os.sleep(10)
    end
    for key, value in pairs(returnValue) do
        print(key, value)
    end
    return returnValue
end

function os.sleep(millis)
    jos.sleep(millis)
end