/**
 * Copyright (c) 2026 LJC
 *
 * SPDX-License-Identifier: GPL-3.0-or-later
 */

#include <iostream>

#define PROJECT_NAME "wsreciever"

void foo() {
    std::cout << "nig";
}

int main(int argc, char **argv) {
    if (argc != 1) {
        std::cout << argv[0] << " takes no arguments.\n";
        return 1;
    }

    std::cout << "This is project " << PROJECT_NAME << ".\n";
    return 0;
}
