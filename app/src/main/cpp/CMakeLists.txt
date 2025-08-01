cmake_minimum_required(VERSION 3.22.1)
project("wauxv-zygisk")

enable_language(CXX C)

set(CMAKE_CXX_STANDARD 20)
set(CMAKE_C_STANDARD 11)

set(CMAKE_SHARED_LINKER_FLAGS "${CMAKE_SHARED_LINKER_FLAGS} -Wl,-z,max-page-size=16384")

add_library(${CMAKE_PROJECT_NAME} SHARED
        main.cpp)

target_link_libraries(${CMAKE_PROJECT_NAME} android log)
