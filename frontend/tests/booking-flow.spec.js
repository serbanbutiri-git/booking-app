import { test, expect } from "@playwright/test";

test("Create user and book flight + hotel", async ({ page }) => {
  // 1. Open app
  await page.goto("http://localhost:5173"); // adjust if different port

  // 2. Create User
  await page.click("text=Create User");
  await page.fill("input[placeholder='Name']", "Test User");
  await page.fill("input[placeholder='Email']", "testuser@example.com");
  await page.click("text=Create");

  // 3. Select User
  await page.selectOption("select.select-wide", { label: /Test User/ });

  // 4. Book Flight
  await page.click("text=Book Flight");
  await page.waitForSelector(".modal-box select");
  await page.selectOption(".modal-box select", { index: 1 }); // pick first flight
  await page.click("text=Confirm Booking");

  // 5. Book Hotel
  await page.click("text=Book Hotel");
  await page.waitForSelector(".modal-box select");
  await page.selectOption(".modal-box select", { index: 1 }); // pick first hotel
  await page.click("text=Confirm Booking");

  // 6. Assert bookings appear
  await expect(page.locator("text=Flight Bookings")).toBeVisible();
  await expect(page.locator("text=Hotel Bookings")).toBeVisible();
});
